package cn.qht2005.ylEcosphere.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VolunteerApplyDto {
	private Long id;
	private String name;
	private Integer gender;
	private LocalDate birthday;
	private String phoneNumber;
	private String email;
	private String address;
	private String description;
	private String experience;
	private LocalDateTime createTime;
}
