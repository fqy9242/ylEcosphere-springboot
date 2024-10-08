package cn.qht2005.ylEcosphere.service;

import cn.qht2005.ylEcosphere.dto.UserLoginDto;
import cn.qht2005.ylEcosphere.dto.UserUpdatePasswordDto;
import cn.qht2005.ylEcosphere.vo.UserLoginVo;

public interface AdminService {
	/**
	 *  管理员登录
	 * @param userLoginDto
	 * @return
	 */
	UserLoginVo login(UserLoginDto userLoginDto);

	/**
	 *  修改登录密爱
	 * @param userId 用户主键
	 * @param currentPassword 当前密码
	 * @param newPassword 新密码
	 */
	void updateLoginPassword(Long userId, UserUpdatePasswordDto userUpdatePasswordDto);
}
