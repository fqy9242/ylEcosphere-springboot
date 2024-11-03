package cn.qht2005.ylEcosphere.dto;

import lombok.Data;

@Data
public class UserFindPasswordDto {
	// 用户名
	private String username;
	// 邮箱
	private String email;
	// 邮件验证码
	private String emailCode;
	// 新密码
	private String newPassword;
}
