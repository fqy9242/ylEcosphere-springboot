package cn.qht2005.ylEcosphere.service;

import cn.qht2005.ylEcosphere.entry.UserIndexSlider;

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
	List<UserIndexSlider> userGetList();
}
