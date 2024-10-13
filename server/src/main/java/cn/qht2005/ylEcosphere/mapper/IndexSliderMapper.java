package cn.qht2005.ylEcosphere.mapper;

import cn.qht2005.ylEcosphere.dto.SliderPageQueryDto;
import cn.qht2005.ylEcosphere.entry.UserIndexSlider;
import com.github.pagehelper.Page;
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
	@Select("select * from user_index_slider where photo_status = #{status} order by id desc")
	List<UserIndexSlider> getListByStatus(Integer status);

	/**
	 *  修改
	 * @param userIndexSlider
	 */
	void update(UserIndexSlider userIndexSlider);

	/**
	 * 获取轮播图列表(所有)
	 * @return
	 */
	@Select("select * from user_index_slider order by id desc")
	List<UserIndexSlider> selectAll();

	/**
	 *  分页查询所有轮播图列表
	 * @param sliderPageQueryDto
	 * @return
	 */
	Page<UserIndexSlider> pageQuery(SliderPageQueryDto sliderPageQueryDto);
	/**
	 * 根据id查询轮播图
	 * @param id 轮播图id
	 * @return
	 */
	@Select("select * from user_index_slider where id = #{id}")
	UserIndexSlider selectById(Long id);
	/**
	 * 添加轮播图
	 * @param userIndexSlider
	 */
	void insert(UserIndexSlider userIndexSlider);
}
