package cn.qht2005.ylEcosphere.service;

import cn.qht2005.ylEcosphere.dto.*;
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

	/**
	 * 找回密码
	 * @param userRegisterDto
	 */
	void forgetPassword(UserFindPasswordDto userRegisterDto);
	/**
	 * 申请志愿者
	 * @param volunteerApplyDto
	 */
	void applyVolunteer(VolunteerApplyDto volunteerApplyDto);

	/**
	 * 志愿者申请分页查询
	 * @param volunteerApplyPageQueryDto
	 * @return
	 */
	PageResult pageForVolunteerApply(VolunteerApplyPageQueryDto volunteerApplyPageQueryDto);

	/**
	 * 同意志愿者申请
	 * @param id
	 */
	void agreeVolunteerApply(Long id, Integer status);
}
