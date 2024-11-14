package cn.qht2005.ylEcosphere.controller.user;

import cn.qht2005.ylEcosphere.dto.VolunteerApplyDto;
import cn.qht2005.ylEcosphere.result.Result;
import cn.qht2005.ylEcosphere.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/volunteer")
@Slf4j
public class VolunteerController {
	@Autowired
	private UserService userService;
	@PostMapping("/apply")
	/**
	 * 申请成为志愿者
	 * @return
	 */
	public Result apply(@RequestBody VolunteerApplyDto volunteerApplyDto) {
		log.info("申请成为志愿者:{}", volunteerApplyDto);
		userService.applyVolunteer(volunteerApplyDto);
		return Result.success();
	}
}
