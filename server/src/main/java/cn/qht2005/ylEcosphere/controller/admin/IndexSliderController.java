package cn.qht2005.ylEcosphere.controller.admin;

import cn.qht2005.ylEcosphere.dto.SliderPageQueryDto;
import cn.qht2005.ylEcosphere.entry.UserIndexSlider;
import cn.qht2005.ylEcosphere.result.PageResult;
import cn.qht2005.ylEcosphere.result.Result;
import cn.qht2005.ylEcosphere.service.IndexSliderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  用户端轮播图
 */
@RestController("adminIndexSliderController")
@Slf4j
@RequestMapping("/admin/indexSlider")
public class IndexSliderController {
	@Autowired
	private IndexSliderService indexSliderService;

	/**
	 *  获取轮播图列表(所有)
	 * @return
	 */
	@GetMapping("/all")
	public Result<PageResult> pageAll(SliderPageQueryDto sliderPageQueryDto) {
		log.info("分页获取所有轮播图:{}", sliderPageQueryDto);
		PageResult pageResult = indexSliderService.page(sliderPageQueryDto);
		return Result.success(pageResult);
	}

	/**
	 *  启用/禁用 轮播图状态
	 * @return
	 */
	@PutMapping("status/{status}")
	public Result startOrStop(Long id, @PathVariable Integer status) {
		log.info("修改轮播图状态id:{}, status:{}", id, status);
		indexSliderService.startOrStop(id, status);
		return Result.success();
	}
	/**
	 *  根据id查询轮播图
	 */
	@GetMapping("/{id}")
	public Result get(@PathVariable Long id) {
		log.info("根据id查询轮播图:{}", id);
		UserIndexSlider userIndexSlider = indexSliderService.getById(id);
		return Result.success(userIndexSlider);
	}
	/**
	 * 添加轮播图
	 */
	@PostMapping("/add")
	public Result add(@RequestBody UserIndexSlider userIndexSlider) {
		log.info("添加轮播图:{}", userIndexSlider);
		indexSliderService.add(userIndexSlider);
		return Result.success();
	}
	/**
	 * 修改轮播图
	 */
	@PutMapping("/{id}")
	public Result update(@PathVariable Long id, @RequestBody UserIndexSlider userIndexSlider) {
		log.info("修改轮播图:{}", userIndexSlider);
		indexSliderService.update(id, userIndexSlider);
		return Result.success();
	}
}
