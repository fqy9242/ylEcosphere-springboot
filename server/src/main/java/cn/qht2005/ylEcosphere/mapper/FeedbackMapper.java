package cn.qht2005.ylEcosphere.mapper;

import cn.qht2005.ylEcosphere.entry.UserFeedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface FeedbackMapper {
	/**
	 * 查询反馈总数
	 * @return
	 */
	@Select("select count(*) from user_feedback")
	Long selectFeedbackTotal();
	/**
	 * 查询所有反馈
	 * @return
	 */
	@Select("select * from user_feedback order by create_time desc")
	List<UserFeedback> selectAll();
	@Update("update user_feedback set feedback_status = #{status} where id = #{id}")
	void updateStatusById(Long id, Integer status);
	/**
	 * 添加反馈
	 * @param userFeedback
	 */
	void insert(UserFeedback userFeedback);
}
