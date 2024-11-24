package cn.qht2005.ylEcosphere.service;

import cn.qht2005.ylEcosphere.entry.RecommendedBook;

import java.util.List;

public interface RecommendedBookService {
	/**
	 * 获取所有推荐书籍
	 * @return
	 */
	List<RecommendedBook> getAll();
}
