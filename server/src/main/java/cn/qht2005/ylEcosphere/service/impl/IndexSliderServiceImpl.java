package cn.qht2005.ylEcosphere.service.impl;

import cn.qht2005.ylEcosphere.entry.UserIndexSlider;
import cn.qht2005.ylEcosphere.mapper.IndexSliderMapper;
import cn.qht2005.ylEcosphere.service.IndexSliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public List<UserIndexSlider> userGetLists() {
		List<UserIndexSlider> list = indexSliderMapper.getListByStatus(UserIndexSlider.STATUS_ENABLE);
		return list;
	}
}
