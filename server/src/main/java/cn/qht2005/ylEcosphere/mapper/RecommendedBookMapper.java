package cn.qht2005.ylEcosphere.mapper;

import cn.qht2005.ylEcosphere.entry.RecommendedBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecommendedBookMapper {
	// TODO 优化：使用分页查询/所使用的字段
	@Select("select * from tb_recommended_book")
	List<RecommendedBook> selectAll();
}
