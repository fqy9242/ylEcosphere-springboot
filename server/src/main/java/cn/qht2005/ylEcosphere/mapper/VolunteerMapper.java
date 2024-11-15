package cn.qht2005.ylEcosphere.mapper;

import cn.qht2005.ylEcosphere.dto.VolunteerApplyDto;
import cn.qht2005.ylEcosphere.dto.VolunteerApplyPageQueryDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
	Page<VolunteerApplyDto> pageQueryForVolunteerApply(VolunteerApplyPageQueryDto volunteerApplyPageQueryDto);
}
