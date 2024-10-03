package cn.qht2005.ylEcosphere.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper {
	/**
	 *  根据角色id查询角色名
	 * @return
	 */
	@Select("select role_name from role where id = #{id}")
	String selectRoleNameById(Integer id);
}
