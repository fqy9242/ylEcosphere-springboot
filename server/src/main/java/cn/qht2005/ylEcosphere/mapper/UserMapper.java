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

	/**
	 *  修改用户信息
	 * @param user
	 */
	void update(User user);

	/**
	 *  根据主键查询用户
	 * @param userId 用户主键
	 * @return
	 */
	@Select("select * from users where id = #{id}")
	User selectById(Long userId);
	/**
	 *  插入用户
	 * @param user
	 */
	void insert(User user);
	// 根据用户名查询用户
	@Select("select * from users where username = #{username}")
	User selectByUsername(String username);
	// 根据邮箱查询用户
	@Select("select * from users where email = #{email}")
	User selectByEmail(String email);

	// 根据用户实体对象查询用户
	User selectByUser(User user);
}
