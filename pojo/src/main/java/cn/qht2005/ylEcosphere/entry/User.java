package cn.qht2005.ylEcosphere.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
//	// 正常
//	private static final Integer  NORMAL = 1;
//	// 异常
//	private static final Integer  UNUSUAL = 0;
	// 主键
	private Long id;
	// 用户名
	private String username;
	//密码
	private String password;
	// 角色类型id
	private Integer roleId;
	// 手机号
	private String phone;
	// 邮箱
	private String email;
	// 头像链接
	private String picture;
	// 账号状态
	private Integer userStatus;
	// 创建时间
	private LocalDateTime createTime;
	//更新时间
	private LocalDateTime updateTime;

}
