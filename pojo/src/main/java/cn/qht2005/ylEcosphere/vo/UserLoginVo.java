package cn.qht2005.ylEcosphere.vo;

import cn.qht2005.ylEcosphere.constant.UserStatusConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginVo {
	// 主键
	private Long id;
	// 用户名
	private String username;
	// 角色类型id
	private Integer roleId;
	// 手机号
	private String phone;
	// 邮箱
	private String email;
	// 头像链接
	private String picture;
	// 账号状态
	private UserStatusConstant status;
	// 创建时间
	private LocalDateTime createTime;
	//更新时间
	private LocalDateTime updateTime;
	// token令牌
	private String token;
}
