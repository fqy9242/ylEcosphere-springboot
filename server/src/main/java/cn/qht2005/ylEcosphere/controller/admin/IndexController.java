package cn.qht2005.ylEcosphere.controller.admin;

import cn.qht2005.ylEcosphere.result.Result;
import cn.qht2005.ylEcosphere.service.AdminService;
import cn.qht2005.ylEcosphere.vo.OverviewVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController("/admin/index")
public class IndexController {
	@Autowired
	private AdminService adminService;
	/**
	 * 获取首页数据
	 * @return
	 */
	@GetMapping("/overviewData")
	public Result<OverviewVo> overview() {
		log.info("获取首页总览数据...");
		OverviewVo overviewVo = adminService.getOverviewData();
		return Result.success(overviewVo);
	}
}
