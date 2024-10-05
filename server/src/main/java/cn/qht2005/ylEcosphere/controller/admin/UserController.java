package cn.qht2005.ylEcosphere.controller.admin;

import cn.qht2005.ylEcosphere.dto.UserLoginDto;
import cn.qht2005.ylEcosphere.dto.UserPageQueryDto;
import cn.qht2005.ylEcosphere.result.PageResult;
import cn.qht2005.ylEcosphere.result.Result;
import cn.qht2005.ylEcosphere.service.UserService;
import cn.qht2005.ylEcosphere.vo.UserLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("adminUserController")
@Slf4j
@RequestMapping("/admin/user")
public class UserController {
	@Autowired
	private UserService userService;
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
	 *  修改用户状态；封号，解封
	 * @return
	 */
	@PostMapping("/status/{status}")
	public Result modifyUserStatus(@PathVariable Integer status, Long id) {
		log.info("修改用户状态:状态->{},id->{}", status, id);
		userService.modifyUserStatus(id, status);
		return Result.success();
	}
}
