package cn.qht2005.ylEcosphere.service.impl;
import cn.qht2005.ylEcosphere.constant.MessageConstant;
import cn.qht2005.ylEcosphere.constant.UserStatusConstant;
import cn.qht2005.ylEcosphere.constant.UserTypeConstant;
import cn.qht2005.ylEcosphere.dto.*;
import cn.qht2005.ylEcosphere.entry.User;
import cn.qht2005.ylEcosphere.exception.BaseException;
import cn.qht2005.ylEcosphere.exception.LoginFailedException;
import cn.qht2005.ylEcosphere.mapper.RoleMapper;
import cn.qht2005.ylEcosphere.mapper.UserMapper;
import cn.qht2005.ylEcosphere.mapper.VolunteerMapper;
import cn.qht2005.ylEcosphere.properties.JwtProperties;
import cn.qht2005.ylEcosphere.result.PageResult;
import cn.qht2005.ylEcosphere.service.UserService;
import cn.qht2005.ylEcosphere.utils.JwtUtil;
import cn.qht2005.ylEcosphere.vo.UserLoginVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private JwtProperties jwtProperties;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private VolunteerMapper volunteerMapper;
	/**
	 * 用户登录
	 *
	 * @param userLoginDto
	 * @return
	 */
	@Override
	public UserLoginVo login(UserLoginDto userLoginDto) {
		// 将传过来的密码加密
		String password = DigestUtils.md5DigestAsHex(userLoginDto.getPassword().getBytes());
		userLoginDto.setPassword(password);
		User user = userMapper.selectByUsernameAndPassword(userLoginDto);
		if (user == null) {
			throw new LoginFailedException("登录失败！用户名或密码错误！");
		}
		// 查询用户状态是否正常
		if (Objects.equals(user.getUserStatus(), UserStatusConstant.UNUSUAL)) {
			throw new LoginFailedException(MessageConstant.USER_STATUS_UNUSUAL);
		}
		// 更新最近登录时间
		user.setLastLoginTime(LocalDateTime.now());
		userMapper.update(user);
		// 获取用户类型
		String roleName = roleMapper.selectRoleNameById(user.getRoleId());
		Map<String, Object> claim = new HashMap<>();
		claim.put("id", user.getUsername());
		// 生成令牌
		String token = JwtUtil.createJWT(jwtProperties.getSecretKey(), jwtProperties.getTtlMillis(), claim);
		// 封装VO对象
		UserLoginVo userLoginVo = new UserLoginVo();
		userLoginVo.setRoleName(roleName);
		BeanUtils.copyProperties(user, userLoginVo);
		userLoginVo.setToken(token);
		userLoginVo.setLoginTime(LocalDateTime.now());
		return userLoginVo;
	}

	/**
	 * 分页查询用户数据
	 *
	 * @param userPageQueryDto
	 * @return
	 */
	@Override
	public PageResult pageQuery(UserPageQueryDto userPageQueryDto) {
		// 分页查询
		PageHelper.startPage(userPageQueryDto.getPage(), userPageQueryDto.getPageSize());
		Page<User> page = userMapper.pageQuery(userPageQueryDto);
		long total = page.getTotal();
		List<User> pageResult = page.getResult();
		return new PageResult(total, pageResult);
	}

	/**
	 * 封禁用户或者解封用户
	 *
	 * @param id
	 * @param status 将要修改成的状态 1.正常 0.封号
	 */
	@Override
	public void modifyUserStatus(Long id, Integer status) {
		User user = new User();
		user.setId(id);
		user.setUserStatus(status);
		user.setUpdateTime(LocalDateTime.now());
		userMapper.update(user);
	}

	/**
	 * 用户注册
	 *
	 * @param userRegisterDto
	 */
	@Override
	public void register(UserRegisterDto userRegisterDto) {
		// 判断redis中是否存在验证码 如果不存在 则表名用户未发送验证码
		Object codeObj = redisTemplate.opsForValue().get(userRegisterDto.getEmail());
		if (codeObj == null) {
			throw new BaseException(MessageConstant.CODE_NOT_SEND);
		}
		// 校验验证码是否正确
		String code = codeObj.toString();
		log.info("用户注册:从redis中获取到验证码:{}", code);

		if (!Objects.equals(code, userRegisterDto.getEmailCode())) {
			throw new BaseException(MessageConstant.CODE_INCORRECT);
		}
		// 创建一个user实体对象 用户查询数据库中的唯一字段是否存在
		User user;
		// 校验用户名是否重复
		user = new User();
		user.setUsername(userRegisterDto.getUsername());
		if (userMapper.selectByUser(user) != null) {
			throw new BaseException(MessageConstant.USERNAME_EXIST);
		}
		user = new User();
		user.setEmail(userRegisterDto.getEmail());
		// 校验邮箱是否重复
		if (userMapper.selectByUser(user) != null) {
			throw new BaseException(MessageConstant.EMAIL_EXIST);
		}
/*		user = new User();
		user.setPhone(userRegisterDto.getPhone());
		// 校验手机号是否重复
		if (userMapper.selectByUser(user) != null) {
			throw new BaseException(MessageConstant.PHONE_EXIST);
		}*/

		user = new User();
		BeanUtils.copyProperties(userRegisterDto, user);
		// 加密一下传进来的密码
		String password = DigestUtils.md5DigestAsHex(userRegisterDto.getPassword().getBytes());
		user.setPassword(password);
		// 设置默认值
		user.setCreateTime(LocalDateTime.now());
		user.setUpdateTime(LocalDateTime.now());
		user.setUserStatus(UserStatusConstant.NORMAL);
		user.setRoleId(UserTypeConstant.USER);
		userMapper.insert(user);
	}

	/**
	 * 找回密码
	 *
	 * @param userRegisterDto
	 */
	@Override
	public void forgetPassword(UserFindPasswordDto userRegisterDto) {
		// 创建一个user实体对象 用户查询数据库中的唯一字段是否存在
		User user = new User();
		user.setEmail(userRegisterDto.getEmail());
		// 校验邮箱是否正确
		user = userMapper.selectByUser(user);
		if (user == null) {
			throw new BaseException(MessageConstant.EMAIL_NOT_INCORRECT);
		}
		// 判断redis中是否存在验证码 如果不存在 则表名用户未发送验证码
		Object codeObj = redisTemplate.opsForValue().get(userRegisterDto.getEmail());
		if (codeObj == null) {
			throw new BaseException(MessageConstant.CODE_NOT_SEND);
		}
		// 校验验证码是否正确
		String code = codeObj.toString();
		log.info("找回密码:从redis中获取到验证码:{}", code);
		if (!Objects.equals(code, userRegisterDto.getEmailCode())) {
			throw new BaseException(MessageConstant.CODE_INCORRECT);
		}
		// 加密一下传进来的密码
		String password = DigestUtils.md5DigestAsHex(userRegisterDto.getNewPassword().getBytes());
		user.setPassword(password);
		user.setUpdateTime(LocalDateTime.now());
		userMapper.update(user);
	}

	/**
	 * 申请志愿者
	 *
	 * @param volunteerApplyDto
	 */
	@Override
	public void applyVolunteer(VolunteerApplyDto volunteerApplyDto) {
		volunteerApplyDto.setCreateTime(LocalDateTime.now());
		volunteerMapper.insertVolunteerApplication(volunteerApplyDto);
	}

	/**
	 * 志愿者申请分页查询
	 *
	 * @param volunteerApplyPageQueryDto
	 * @return
	 */
	@Override
	public PageResult pageForVolunteerApply(VolunteerApplyPageQueryDto volunteerApplyPageQueryDto) {
		PageHelper.startPage(volunteerApplyPageQueryDto.getPage(), volunteerApplyPageQueryDto.getPageSize());
		Page<VolunteerApplyDto> page = volunteerMapper.pageQueryForVolunteerApply(volunteerApplyPageQueryDto);
		PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
 		return pageResult;
	}


}
