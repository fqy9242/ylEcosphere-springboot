package cn.qht2005.ylEcosphere.mapper;

import cn.qht2005.ylEcosphere.entry.UserIndexSlider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
/**
 *  用户端轮播图mapper
 */
public interface IndexSliderMapper {
	/**
	 *  根据状态获取列表
	 * @return
	 */
	@Select("select  * from user_index_slider where photo_status = #{status}")
	List<UserIndexSlider> getListByStatus(Integer status);
}
