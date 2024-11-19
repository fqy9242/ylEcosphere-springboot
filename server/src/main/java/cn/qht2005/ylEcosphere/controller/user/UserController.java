package cn.qht2005.ylEcosphere.controller.user;

import cn.qht2005.ylEcosphere.dto.UserFindPasswordDto;
import cn.qht2005.ylEcosphere.dto.UserLoginDto;
import cn.qht2005.ylEcosphere.dto.UserPageQueryDto;
import cn.qht2005.ylEcosphere.dto.UserRegisterDto;
import cn.qht2005.ylEcosphere.entry.UserFeedback;
import cn.qht2005.ylEcosphere.result.PageResult;
import cn.qht2005.ylEcosphere.result.Result;
import cn.qht2005.ylEcosphere.service.FeedbackService;
import cn.qht2005.ylEcosphere.service.UserService;
import cn.qht2005.ylEcosphere.vo.UserLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private FeedbackService feedbackService;
	/**
	 *  用户登录
	 * @return
	 */
	@PostMapping("/login")
	public Result<UserLoginVo> login(@RequestBody UserLoginDto userLoginDto) {
		log.info("用户登录:{}", userLoginDto);
		UserLoginVo userLoginVo = userService.login(userLoginDto);
		return Result.success(userLoginVo);
	}

	/**
	 *  员工分页查询
	 * @param userPageQueryDto
	 * @return
	 */
	@GetMapping("/page")
	public  Result<PageResult> list(UserPageQueryDto userPageQueryDto) {
		log.info("员工分页查询:{}", userPageQueryDto);
		PageResult list = userService.pageQuery(userPageQueryDto);
		return Result.success(list);
	}

	/**
	 *  用户注册
	 * @param userRegisterDto
	 * @return
	 */
	@PostMapping("/register")
	public Result register(@RequestBody UserRegisterDto userRegisterDto) {
		log.info("用户注册:{}", userRegisterDto);
		userService.register(userRegisterDto);
		return Result.success();
	}
	@PostMapping("/findPassword")
	public Result forgetPassword(@RequestBody UserFindPasswordDto userRegisterDto) {
		log.info("找回密码:{}", userRegisterDto);
		userService.forgetPassword(userRegisterDto);
		return Result.success();
	}
	/**
	 * 添加反馈
	 * @param userFeedback
	 * @return
	 */
	@PostMapping("/feedback/add")
	public Result add(@RequestBody UserFeedback userFeedback) {
		log.info("添加反馈: {}", userFeedback);
		feedbackService.addFeedback(userFeedback);
		return Result.success();
	}
}
