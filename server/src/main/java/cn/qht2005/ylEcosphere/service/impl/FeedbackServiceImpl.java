package cn.qht2005.ylEcosphere.service.impl;

import cn.qht2005.ylEcosphere.entry.UserFeedback;
import cn.qht2005.ylEcosphere.mapper.FeedbackMapper;
import cn.qht2005.ylEcosphere.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackMapper feedbackMapper;

	/**
	 * 获取反馈列表
	 *
	 * @return 反馈列表
	 */
	@Override
	public List<UserFeedback> getFeedbackList() {
		return feedbackMapper.selectAll();
	}

	/**
	 * 更新反馈状态
	 *
	 * @param id
	 * @param status
	 */
	@Override
	public void updateFeedbackStatus(Long id, Integer status) {
		feedbackMapper.updateStatusById(id, status);
	}
}
