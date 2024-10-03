package cn.qht2005.ylEcosphere.service;

import cn.qht2005.ylEcosphere.dto.UserLoginDto;
import cn.qht2005.ylEcosphere.vo.UserLoginVo;

public interface AdminService {
	/**
	 *  管理员登录
	 * @param userLoginDto
	 * @return
	 */
	UserLoginVo login(UserLoginDto userLoginDto);
}
