package cn.qht2005.ylEcosphere.dto;

import lombok.Data;

/**
 *  用户分页查询dto
 */
@Data
public class UserPageQueryDto {
	// 用户名
	private String username;
	// 用户状态
	private Integer status;
	// 手机号
	private String phone;
	// 用户类型id
	private Integer roleId;
	// 经历
	private String experience;
	// 页码
	private int page;
	// 每页记录数
	private int pageSize;
}
