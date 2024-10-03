package cn.qht2005.ylEcosphere.service;

import cn.qht2005.ylEcosphere.dto.UserLoginDto;
import cn.qht2005.ylEcosphere.dto.UserPageQueryDto;
import cn.qht2005.ylEcosphere.result.PageResult;
import cn.qht2005.ylEcosphere.vo.UserLoginVo;

public interface UserService {
	/**
	 *  用户登录
	 * @param userLoginDto
	 * @return
	 */
	UserLoginVo login(UserLoginDto userLoginDto);

	/**
	 *  分页查询用户数据
	 * @param userPageQueryDto
	 * @return
	 */
	PageResult pageQuery(UserPageQueryDto userPageQueryDto);
}
