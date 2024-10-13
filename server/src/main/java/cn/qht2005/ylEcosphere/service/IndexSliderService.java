package cn.qht2005.ylEcosphere.service;

import cn.qht2005.ylEcosphere.dto.SliderPageQueryDto;
import cn.qht2005.ylEcosphere.entry.UserIndexSlider;
import cn.qht2005.ylEcosphere.result.PageResult;

import java.util.List;

public interface IndexSliderService {
	/**
	 *  获取用户端轮播图列表
	 * @return
	 */
	List<UserIndexSlider> userGetEnableLists();

	/**
	 *  修改轮播图状态
	 * @param id
	 * @param status
	 */
	void startOrStop(Long id, Integer status);

	/**
	 *  获取轮播图列表(所有)
	 * @return
	 */
	PageResult page(SliderPageQueryDto sliderPageQueryDto);

	/**
	 * 根据id查询轮播图
	 * @param id 轮播图id
	 * @return
	 */
	UserIndexSlider getById(Long id);
	/**
	 * 添加轮播图
	 * @param userIndexSlider
	 */
	void add(UserIndexSlider userIndexSlider);
	/**
	 * 修改轮播图
	 * @param id
	 * @param userIndexSlider
	 */
	void update(Long id, UserIndexSlider userIndexSlider);
}
