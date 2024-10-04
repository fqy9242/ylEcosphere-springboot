package cn.qht2005.ylEcosphere.mapper;

import cn.qht2005.ylEcosphere.dto.UserLoginDto;
import cn.qht2005.ylEcosphere.dto.UserPageQueryDto;
import cn.qht2005.ylEcosphere.entry.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	/**
	 *  根据用户名以及密码查询用户信息
	 * @param loginDto 用户名以及密码封装对象
	 * @return 用户实体对象
	 */
	@Select("select * from users where username = #{username} and password = #{password}")
	User selectByUsernameAndPassword(UserLoginDto loginDto);

	/**
	 *  分页查询
	 * @param userPageQueryDto
	 * @return
	 */
	Page<User> pageQuery(UserPageQueryDto userPageQueryDto);
}
