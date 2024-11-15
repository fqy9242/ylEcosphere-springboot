package cn.qht2005.ylEcosphere.dto;

import lombok.Data;

@Data
public class VolunteerApplyPageQueryDto {
	// 志愿者姓名
	private String name;
	// 志愿者联系邮箱
	private String email;
	// 志愿者描述
	private String description;
	// 经历
	private String experience;
	// 申请状态
	private Integer applyStatus;
	// 页码
	private int page;
	// 每页记录数
	private int pageSize;
}
