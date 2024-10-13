package cn.qht2005.ylEcosphere.service.impl;

import cn.qht2005.ylEcosphere.entry.UserIndexSlider;
import cn.qht2005.ylEcosphere.mapper.IndexSliderMapper;
import cn.qht2005.ylEcosphere.service.IndexSliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service

public class IndexSliderServiceImpl implements IndexSliderService {
	@Autowired
	private IndexSliderMapper indexSliderMapper;
	/**
	 * 获取用户端轮播图列表
	 *
	 * @return
	 */
	@Override
	public List<UserIndexSlider> userGetEnableLists() {
		List<UserIndexSlider> list = indexSliderMapper.getListByStatus(UserIndexSlider.STATUS_ENABLE);
		return list;
	}

	/**
	 * 修改轮播图状态
	 *
	 * @param id
	 * @param status
	 */
	@Override
	public void startOrStop(Long id, Integer status) {
		// 将传进来的参数封装成实体对象
		UserIndexSlider userIndexSlider = UserIndexSlider.builder()
				.id(id)
				.photoStatus(status)
				.updateTime(LocalDateTime.now())
				.build();
		indexSliderMapper.update(userIndexSlider);
	}

	/**
	 * 获取轮播图列表(所有)
	 *
	 * @return
	 */
	@Override
	public List<UserIndexSlider> userGetList() {
		List<UserIndexSlider> list = indexSliderMapper.selectAll();
		return list;
	}
}
