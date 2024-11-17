package cn.qht2005.ylEcosphere.mapper;

import cn.qht2005.ylEcosphere.dto.VolunteerApplyDto;
import cn.qht2005.ylEcosphere.dto.VolunteerApplyPageQueryDto;
import cn.qht2005.ylEcosphere.vo.VolunteerApplyVo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;

@Mapper
public interface VolunteerMapper {
	/**
	 *  查询志愿者申请总数
	 * @return
	 */
	@Select("select count(*) from volunteer_application")
	Long selectVolunteerApplicationTotal();
	/**
	 *  插入志愿者申请
	 */
	void insertVolunteerApplication(VolunteerApplyDto volunteerApplyDto);
	/**
	 *  分页查询志愿者申请
	 * @param volunteerApplyPageQueryDto
	 * @return
	 */
	Page<VolunteerApplyVo> pageQueryForVolunteerApply(VolunteerApplyPageQueryDto volunteerApplyPageQueryDto);

	/**
	 * 通过id更新申请状态
	 * @param id
	 * @param i
	 */
	@Update("update volunteer_application set apply_status = #{i} where id = #{id}")
	void updateApplyStatusById(Long id, int i);

	/**
	 * 通过id查询志愿者申请
	 * @param id
	 * @return
	 */
	@Select("select * from volunteer_application where id = #{id}")
	VolunteerApplyVo selectVolunteerApplyById(Long id);

	/**
	 * 查询某一天的志愿者申请数量
	 * @param date
	 * @return
	 */
	@Select("select count(*) from volunteer_application where DATE_FORMAT(create_time, '%Y-%m-%d') = #{date}")
	Long selectVolunteerApplyCountByDate(LocalDate date);
}
