package cn.qht2005.ylEcosphere.dto;

import lombok.Data;

@Data
public class UserRegisterDto {
	// 用户名
	private String username;
	// 密码
	private String password;
	// 手机号
	private String phone;
	// 用户头像
	private String picture;
	// 邮箱
	private String email;
	// 邮件验证码
	private String code;
}
