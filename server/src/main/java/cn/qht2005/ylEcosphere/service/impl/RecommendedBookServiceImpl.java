package cn.qht2005.ylEcosphere.service.impl;

import cn.qht2005.ylEcosphere.entry.RecommendedBook;
import cn.qht2005.ylEcosphere.mapper.RecommendedBookMapper;
import cn.qht2005.ylEcosphere.service.RecommendedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendedBookServiceImpl implements RecommendedBookService {
	@Autowired
	private RecommendedBookMapper recommendedBookMapper;
	/**
	 * 获取所有推荐书籍
	 *
	 * @return
	 */
	@Override
	public List<RecommendedBook> getAll() {
		return recommendedBookMapper.selectAll();
	}
}
