package cn.qht2005.ylEcosphere.dto;

import lombok.Data;

@Data
public class UserUpdatePasswordDto {
	// 当前密码
	private String currentPassword;
	// 新密码
	private String newPassword;
}
