package cn.qht2005.ylEcosphere.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFeedback {
	// 主键
	private Long id;
	// 用户id
	private Long userId;
	// 邮箱
	private String email;
	// 手机号
	private String phoneNumber;
	// 反馈标题
	private String title;
	// 反馈内容
	private String content;
	// 反馈状态
	private Integer feedbackStatus;
	// 创建时间
	private String createTime;
	// 更新时间
	private String updateTime;
}
