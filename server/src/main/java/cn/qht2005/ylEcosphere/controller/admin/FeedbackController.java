package cn.qht2005.ylEcosphere.controller.admin;

import cn.qht2005.ylEcosphere.entry.UserFeedback;
import cn.qht2005.ylEcosphere.result.Result;
import cn.qht2005.ylEcosphere.service.FeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/feedback")
@Slf4j
public class FeedbackController {
	@Autowired
	private FeedbackService feedbackService;
	/**
	 * 查询所有反馈
	 * @return
	 */
	@GetMapping("/list")
	public Result<List<UserFeedback>> list() {
		log.info("查询所有反馈");
		return Result.success(feedbackService.getFeedbackList());
	}

	/**
	 * 更新反馈状态
	 * @param id
	 * @param status
	 * @return
	 */
	@PutMapping("/status/{status}")
	public Result updateStatus(Long id, @PathVariable Integer status) {
		log.info("更新反馈状态: id={}, status={}", id, status);
		feedbackService.updateFeedbackStatus(id, status);
		return Result.success();
	}
}
