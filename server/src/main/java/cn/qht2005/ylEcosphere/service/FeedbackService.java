package cn.qht2005.ylEcosphere.service;

import cn.qht2005.ylEcosphere.entry.UserFeedback;

import java.util.List;

public interface FeedbackService {
	/**
	 * 获取反馈列表
	 * @return 反馈列表
	 */
	List<UserFeedback> getFeedbackList();

	/**
	 * 更新反馈状态
	 * @param id
	 * @param status
	 */
	void updateFeedbackStatus(Long id, Integer status);

	/**
	 * 添加反馈
	 * @param userFeedback
	 */
	void addFeedback(UserFeedback userFeedback);
}
