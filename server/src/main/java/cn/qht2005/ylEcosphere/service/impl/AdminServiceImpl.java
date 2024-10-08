package cn.qht2005.ylEcosphere.service.impl;
import cn.qht2005.ylEcosphere.constant.MessageConstant;
import cn.qht2005.ylEcosphere.constant.RoleIdConstant;
import cn.qht2005.ylEcosphere.dto.UserLoginDto;
import cn.qht2005.ylEcosphere.dto.UserUpdatePasswordDto;
import cn.qht2005.ylEcosphere.entry.User;
import cn.qht2005.ylEcosphere.exception.AccountNotExistException;
import cn.qht2005.ylEcosphere.exception.BaseException;
import cn.qht2005.ylEcosphere.exception.LoginFailedException;
import cn.qht2005.ylEcosphere.mapper.RoleMapper;
import cn.qht2005.ylEcosphere.mapper.UserMapper;
import cn.qht2005.ylEcosphere.properties.JwtProperties;
import cn.qht2005.ylEcosphere.service.AdminService;
import cn.qht2005.ylEcosphere.utils.JwtUtil;
import cn.qht2005.ylEcosphere.vo.UserLoginVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {
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
		userLoginDto.setPassword(DigestUtils.md5DigestAsHex(userLoginDto.getPassword().getBytes()));
		User user = userMapper.selectByUsernameAndPassword(userLoginDto);
		if (user == null) {
			throw new LoginFailedException("登录失败！用户名或密码错误！");
		}
		// 获取用户类型
		String roleName = roleMapper.selectRoleNameById(user.getRoleId());
		if (! "管理员".equals(roleName)) {
			throw new LoginFailedException("仅允许管理员登录！");
		}
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
	 * 修改登录密爱
	 *
	 * @param userId 用户主键
	 */
	@Override
	public void updateLoginPassword(Long userId, UserUpdatePasswordDto userUpdatePasswordDto) {
		// 根据id,查询用户
		User user = userMapper.selectById(userId);
		// 用户不存在
		if (user == null || user.getRoleId() != RoleIdConstant.admin) {
			throw new AccountNotExistException();
		}
		// 将传进来的原密码进行加密
		String currentPassword = DigestUtils.md5DigestAsHex(userUpdatePasswordDto.getCurrentPassword().getBytes());
		// 判断原密码是否正确
		if (!Objects.equals(user.getPassword(), currentPassword)) {
			// 原密码不正确
			throw new BaseException(MessageConstant.PASSWORD_INCORRECT);
		}
		// 修改密码
		// 1. 将传来的新密码进行加密
		String password = DigestUtils.md5DigestAsHex(userUpdatePasswordDto.getNewPassword().getBytes());
		// 2. 修改user实体对象的属性
		user.setPassword(password);
		user.setUpdateTime(LocalDateTime.now());
		// 3.调用mapper修改密码
		userMapper.update(user);
	}
}
