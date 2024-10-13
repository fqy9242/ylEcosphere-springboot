package cn.qht2005.ylEcosphere.service.impl;

import cn.qht2005.ylEcosphere.dto.SliderPageQueryDto;
import cn.qht2005.ylEcosphere.entry.UserIndexSlider;
import cn.qht2005.ylEcosphere.mapper.IndexSliderMapper;
import cn.qht2005.ylEcosphere.result.PageResult;
import cn.qht2005.ylEcosphere.service.IndexSliderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
	 * 分页查询获取轮播图列表(所有)
	 *
	 * @return
	 */
	@Override
	public PageResult page(SliderPageQueryDto sliderPageQueryDto) {
		// 分页查询
		PageHelper.startPage(sliderPageQueryDto.getPage(), sliderPageQueryDto.getPageSize());
		Page<UserIndexSlider> page = indexSliderMapper.pageQuery(sliderPageQueryDto);
		long total = page.getTotal();
		List<UserIndexSlider> list = page.getResult();
		return new PageResult(total, list);
	}
}
