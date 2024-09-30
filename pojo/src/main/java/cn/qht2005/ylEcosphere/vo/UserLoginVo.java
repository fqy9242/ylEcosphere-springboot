package cn.qht2005.ylEcosphere.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginVo {
	// 主键
	private Long id;
	// 用户名
	private String username;
	// token令牌
	private String token;
}
