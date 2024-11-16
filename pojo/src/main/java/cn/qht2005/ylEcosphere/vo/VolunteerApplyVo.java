package cn.qht2005.ylEcosphere.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
		import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerApplyVo {
	private Long id;
	private String name;
	private Integer gender;
	private LocalDate birthday;
	private Integer age;
	private String phoneNumber;
	private String email;
	private String address;
	private String description;
	private String experience;
	private Integer applyStatus;
	private LocalDateTime createTime;
}
