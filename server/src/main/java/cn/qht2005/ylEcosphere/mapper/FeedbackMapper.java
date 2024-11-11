package cn.qht2005.ylEcosphere.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FeedbackMapper {
	/**
	 * 查询反馈总数
	 * @return
	 */
	@Select("select count(*) from user_feedback")
	Long selectFeedbackTotal();
}
