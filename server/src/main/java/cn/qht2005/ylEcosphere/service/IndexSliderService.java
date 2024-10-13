package cn.qht2005.ylEcosphere.service;

import cn.qht2005.ylEcosphere.entry.UserIndexSlider;

import java.util.List;

public interface IndexSliderService {
	/**
	 *  获取用户端轮播图列表
	 * @return
	 */
	List<UserIndexSlider> userGetLists();
}
