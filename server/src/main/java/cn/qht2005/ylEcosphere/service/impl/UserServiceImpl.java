package cn.qht2005.ylEcosphere.service.impl;
import cn.qht2005.ylEcosphere.constant.MessageConstant;
import cn.qht2005.ylEcosphere.constant.UserStatusConstant;
import cn.qht2005.ylEcosphere.constant.UserTypeConstant;
import cn.qht2005.ylEcosphere.dto.UserLoginDto;
import cn.qht2005.ylEcosphere.dto.UserPageQueryDto;
import cn.qht2005.ylEcosphere.dto.UserRegisterDto;
import cn.qht2005.ylEcosphere.entry.User;
import cn.qht2005.ylEcosphere.exception.LoginFailedException;
import cn.qht2005.ylEcosphere.mapper.RoleMapper;
import cn.qht2005.ylEcosphere.mapper.UserMapper;
import cn.qht2005.ylEcosphere.properties.JwtProperties;
import cn.qht2005.ylEcosphere.result.PageResult;
import cn.qht2005.ylEcosphere.service.UserService;
import cn.qht2005.ylEcosphere.utils.JwtUtil;
import cn.qht2005.ylEcosphere.vo.UserLoginVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private JwtProperties jwtProperties;
	@Autowired
	private RoleMapper roleMapper;
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
		User user = new User();
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
}
