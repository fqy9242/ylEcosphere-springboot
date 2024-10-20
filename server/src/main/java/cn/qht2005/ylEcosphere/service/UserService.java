package cn.qht2005.ylEcosphere.service;

import cn.qht2005.ylEcosphere.dto.UserLoginDto;
import cn.qht2005.ylEcosphere.dto.UserPageQueryDto;
import cn.qht2005.ylEcosphere.dto.UserRegisterDto;
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

	/**
	 *  封禁用户或者解封用户
	 * @param id
	 * @param status 将要修改成的状态 1.正常 0.封号
	 */
	void modifyUserStatus(Long id, Integer status);
	/**
	 *  用户注册
	 * @param userRegisterDto
	 */
	void register(UserRegisterDto userRegisterDto);
}
