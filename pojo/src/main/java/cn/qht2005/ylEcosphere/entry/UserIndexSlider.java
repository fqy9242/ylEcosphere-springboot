package cn.qht2005.ylEcosphere.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 *  用户端首页轮播图实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserIndexSlider {
	// 启用
	public static final Integer  STATUS_ENABLE = 1;
	// 禁用
	public static final Integer  STATUS_DISABLE = 0;
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
}
