package cn.qht2005.ylEcosphere.controller.user;

import cn.qht2005.ylEcosphere.entry.RecommendedBook;
import cn.qht2005.ylEcosphere.result.Result;
import cn.qht2005.ylEcosphere.service.RecommendedBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/common/recommendedBook")
@Slf4j
public class RecommendedBookController {
	@Autowired
	private RecommendedBookService recommendedBookService;
	/**
	 * 获取所有推荐书籍
	 * @return
	 */
	@GetMapping("/all")
	public Result all() {
		log.info("获取所有推荐书籍");
		List<RecommendedBook> books = recommendedBookService.getAll();
		return Result.success(books);
	}

}
