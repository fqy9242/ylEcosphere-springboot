package cn.qht2005.ylEcosphere.controller.user;

import cn.qht2005.ylEcosphere.entry.UserIndexSlider;
import cn.qht2005.ylEcosphere.result.Result;
import cn.qht2005.ylEcosphere.service.IndexSliderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	 *  获取轮播图列表
	 * @return
	 */
	@GetMapping("/list")
	public Result<List<UserIndexSlider>> list() {
		log.info("获取轮播图……");
		List<UserIndexSlider> userIndexSliders = indexSliderService.userGetLists();
		return Result.success(userIndexSliders);
	}
}
