package cn.qht2005.ylEcosphere.mapper;

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
}
