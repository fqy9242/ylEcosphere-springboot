package cn.qht2005.ylEcosphere.service;

import cn.qht2005.ylEcosphere.dto.UserLoginDto;
import cn.qht2005.ylEcosphere.dto.UserUpdatePasswordDto;
import cn.qht2005.ylEcosphere.vo.IndexChartDataVo;
import cn.qht2005.ylEcosphere.vo.OverviewVo;
import cn.qht2005.ylEcosphere.vo.UserLoginVo;

public interface AdminService {
	/**
	 *  管理员登录
	 * @param userLoginDto
	 * @return
	 */
	UserLoginVo login(UserLoginDto userLoginDto);

	/**
	 *  修改登录密爱
	 * @param userId 用户主键
	 * @param userUpdatePasswordDto 当前密码
	 */
	void updateLoginPassword(Long userId, UserUpdatePasswordDto userUpdatePasswordDto);
	/**
	 *  获取首页数据
	 * @return
	 */
	OverviewVo getOverviewData();

	/**
	 *  返回管理端首页图表数据
	 * @return 图表数据
	 */
	IndexChartDataVo getIndexChartData();
}
