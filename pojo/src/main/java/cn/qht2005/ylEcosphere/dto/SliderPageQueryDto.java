package cn.qht2005.ylEcosphere.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SliderPageQueryDto {
	// 主键
	private Long id;
	// 轮播图标题
	private String title;
	// 轮播图url
	private String photo;
	// 轮播图状态 0.禁用 1.启用
	private  Integer photoStatus;
	// 轮播图描述
	private String photoDesc;
	// 创建时间
	private LocalDateTime createTime;
	// 更新时间
	private LocalDateTime updateTime;
	// 页码
	private int page;
	// 每页记录数
	private int pageSize;

}
