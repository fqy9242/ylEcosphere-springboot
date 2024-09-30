package cn.qht2005.ylEcosphere.controller.user;

import cn.qht2005.ylEcosphere.dto.UserLoginDto;
import cn.qht2005.ylEcosphere.result.Result;
import cn.qht2005.ylEcosphere.service.UserService;
import cn.qht2005.ylEcosphere.vo.UserLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
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
}
