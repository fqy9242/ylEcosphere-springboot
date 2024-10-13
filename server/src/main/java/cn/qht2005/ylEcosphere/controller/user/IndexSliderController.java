package cn.qht2005.ylEcosphere.controller.user;

import cn.qht2005.ylEcosphere.entry.UserIndexSlider;
import cn.qht2005.ylEcosphere.result.Result;
import cn.qht2005.ylEcosphere.service.IndexSliderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  用户端轮播图
 */
@RestController
@Slf4j
@RequestMapping("/user/indexSlider")
public class IndexSliderController {
	@Autowired
	private IndexSliderService indexSliderService;
	/**
	 *  获取轮播图列表(启用状态)
	 * @return
	 */
	@GetMapping("/list")
	public Result<List<UserIndexSlider>> list() {
		log.info("获取轮播图……");
		List<UserIndexSlider> userIndexSliders = indexSliderService.userGetEnableLists();
		return Result.success(userIndexSliders);
	}

	/**
	 *  获取轮播图列表(所有)
	 * @return
	 */
	@GetMapping("/all")
	public Result<List<UserIndexSlider>> all() {
		log.info("获取所有轮播图……");
		List<UserIndexSlider> userIndexSliders = indexSliderService.userGetList();
		return Result.success(userIndexSliders);
	}


	/**
	 *  启用/禁用 轮播图状态
	 * @return
	 */
	@GetMapping("/{status}")
	public Result startOrStop(Long id, @PathVariable Integer status) {
		log.info("修改轮播图状态id:{}, status:{}", id, status);
		indexSliderService.startOrStop(id, status);
		return Result.success();
	}
}
