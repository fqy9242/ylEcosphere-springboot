package cn.qht2005.ylEcosphere.service;

public interface EmailService {
	void sendEmailCode(String email) throws Exception;
	void sendAgreeOrRefuseVolunteerApply(String email, String name, String status) throws Exception;
 }
