package cn.qht2005.ylEcosphere.vo;

import lombok.Data;

@Data
public class OverviewVo {
	// 总用户数
	private Long userTotal;
	// 日活跃用户数
	private Long dailyActivityUserTotal;
	// 累计志愿者
	private Long volunteerTotal;
	// 反馈数量
	private Long feedbackTotal;
}
