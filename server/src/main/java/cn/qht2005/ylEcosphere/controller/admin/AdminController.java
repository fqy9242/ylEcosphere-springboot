package cn.qht2005.ylEcosphere.controller.admin;

import cn.qht2005.ylEcosphere.dto.UserLoginDto;
import cn.qht2005.ylEcosphere.dto.UserUpdatePasswordDto;
import cn.qht2005.ylEcosphere.dto.VolunteerApplyPageQueryDto;
import cn.qht2005.ylEcosphere.result.PageResult;
import cn.qht2005.ylEcosphere.result.Result;
import cn.qht2005.ylEcosphere.service.AdminService;
import cn.qht2005.ylEcosphere.service.UserService;
import cn.qht2005.ylEcosphere.vo.UserLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;

	/**
	 *  管理员登录
	 * @return
	 */
	@PostMapping("/login")
	public Result<UserLoginVo> login(@RequestBody UserLoginDto userLoginDto) {
		log.info("管理员登录:{}", userLoginDto);
		UserLoginVo userLoginVo = adminService.login(userLoginDto);
		return Result.success(userLoginVo);
	}

	/**
	 *  修改登录密码
	 */
	@PutMapping("/{userId}/password")
	public Result updateLoginPassword(@PathVariable Long userId, @RequestBody UserUpdatePasswordDto userUpdatePasswordDto) {
		log.info("管理员id{}修改登录密码,{}", userId, userUpdatePasswordDto);
		adminService.updateLoginPassword(userId,userUpdatePasswordDto);
		return Result.success();
	}

	/**
	 *  志愿者申请分页查询
	 */
	@GetMapping("/volunteerApply/page")
	public Result<PageResult> pageForVolunteerApply(@RequestBody VolunteerApplyPageQueryDto volunteerApplyPageQueryDto) {
		log.info("志愿者申请分页查询:{}", volunteerApplyPageQueryDto);
		PageResult pageResult = userService.pageForVolunteerApply(volunteerApplyPageQueryDto);
		return Result.success(pageResult);
	}
}
