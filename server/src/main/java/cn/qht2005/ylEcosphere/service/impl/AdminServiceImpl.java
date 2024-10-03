package cn.qht2005.ylEcosphere.service.impl;
import cn.qht2005.ylEcosphere.dto.UserLoginDto;
import cn.qht2005.ylEcosphere.entry.User;
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

import java.util.HashMap;
import java.util.Map;

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
}
