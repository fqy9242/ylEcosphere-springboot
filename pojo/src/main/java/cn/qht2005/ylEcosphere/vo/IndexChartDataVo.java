package cn.qht2005.ylEcosphere.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class IndexChartDataVo {
	// 统计时间列表
	private List<LocalDate> dates;
	// 日注册用户数
	private List<Long> registerUserCount;
}
