package cn.qht2005.ylEcosphere.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendedBook {
	// 主键
	private Integer id;
	// 书名
	private String bookName;
	// 介绍，描述
	private String description;
	// 封面
	private String bookCover;
	// 作者
	private String bookAuthor;
	// 作者国籍
	private String authorNationality;
	// 书籍类型
	private Integer bookType;
	// 创建时间
	private LocalDateTime createTime;
	// 更新时间
	private LocalDateTime updateTime;
}
