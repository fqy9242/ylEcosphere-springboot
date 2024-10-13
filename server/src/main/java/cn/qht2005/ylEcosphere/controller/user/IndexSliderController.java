package cn.qht2005.ylEcosphere.controller.user;

import cn.qht2005.ylEcosphere.dto.SliderPageQueryDto;
import cn.qht2005.ylEcosphere.entry.UserIndexSlider;
import cn.qht2005.ylEcosphere.result.PageResult;
import cn.qht2005.ylEcosphere.result.Result;
import cn.qht2005.ylEcosphere.service.IndexSliderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 *  用户端轮播图
 */
@RestController("userIndexSliderController")
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

}
