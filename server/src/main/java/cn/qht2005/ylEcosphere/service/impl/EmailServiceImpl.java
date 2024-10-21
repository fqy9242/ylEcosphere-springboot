package cn.qht2005.ylEcosphere.service.impl;

import cn.qht2005.ylEcosphere.service.EmailService;
import cn.qht2005.ylEcosphere.utils.CodeUtil;
import cn.qht2005.ylEcosphere.utils.SendEmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private SendEmailUtil sendEmailUtil;
	@Override
	public void sendEmailCode(String email) throws Exception {
		// 生成6位验证码
		String code = CodeUtil.createCode(6);
		String html = "<!DOCTYPE html>\n" +
				"<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
				"<head>\n" +
				"    <meta charset=\"utf-8\">\n" +
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
				"    <meta name=\"description\" content=\"email code\">\n" +
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
				"</head>\n" +
				"<!--邮箱验证码模板-->\n" +
				"<body>\n" +
				"<div style=\"background-color:#ECECEC; padding: 35px;\">\n" +
				"    <table cellpadding=\"0\" align=\"center\"\n" +
				"           style=\"width: 800px;height: 100%; margin: 0px auto; text-align: left; position: relative; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; font-size: 14px; font-family:微软雅黑, 黑体; line-height: 1.5; box-shadow: rgb(153, 153, 153) 0px 0px 5px; border-collapse: collapse; background-position: initial initial; background-repeat: initial initial;background:#fff;\">\n" +
				"        <tbody>\n" +
				"        <tr>\n" +
				"            <th valign=\"middle\"\n" +
				"                style=\"height: 25px; line-height: 25px; padding: 15px 35px; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: RGB(148,0,211); background-color: RGB(148,0,211); border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px;\">\n" +
				"                <font face=\"微软雅黑\" size=\"5\" style=\"color: rgb(255, 255, 255); \">悦绿生态圈</font>\n" +
				"            </th>\n" +
				"        </tr>\n" +
				"        <tr>\n" +
				"            <td style=\"word-break:break-all\">\n" +
				"                <div style=\"padding:25px 35px 40px; background-color:#fff;opacity:0.8;\">\n" +
				"\n" +
				"                    <h2 style=\"margin: 5px 0px; \">\n" +
				"                        <font color=\"#333333\" style=\"line-height: 20px; \">\n" +
				"                            <font style=\"line-height: 22px; \" size=\"4\">\n" +
				"                                尊敬的用户：</font>\n" +
				"                        </font>\n" +
				"                    </h2>\n" +
				"                    <!-- 中文 -->\n" +
				"                    <p>您好！感谢您使用悦绿生态圈，您的账号正在进行邮箱验证，验证码为：<font color=\"#ff8c00\">{0}</font>，有效期30分钟，请尽快填写验证码完成验证！</p><br>\n" +
				"                    <!-- 英文 -->\n" +
				"                    <h2 style=\"margin: 5px 0px; \">\n" +
				"                        <font color=\"#333333\" style=\"line-height: 20px; \">\n" +
				"                            <font style=\"line-height: 22px; \" size=\"4\">\n" +
				"                                Dear user:</font>\n" +
				"                        </font>\n" +
				"                    </h2>\n" +
				"                    <p>Hello! Thanks for using 悦绿生态圈, your account is being authenticated by email, the\n" +
				"                        verification code is:<font color=\"#ff8c00\">{0}</font>, valid for 30 minutes. Please fill in the verification code as soon as\n" +
				"                        possible!</p>\n" +
				"                    <div style=\"width:100%;margin:0 auto;\">\n" +
				"                        <div style=\"padding:10px 10px 0;border-top:1px solid #ccc;color:#747474;margin-bottom:20px;line-height:1.3em;font-size:12px;\">\n" +
				"                            <p>悦绿生态圈团队</p>\n" +
				"                            <p>联系我们：59605904@qq.com</p>\n" +
				"                            <br>\n" +
				"                            <p>此为系统邮件，请勿回复<br>\n" +
				"                                Please do not reply to this system email\n" +
				"                            </p>\n" +
				"                            <!--<p>©***</p>-->\n" +
				"                        </div>\n" +
				"                    </div>\n" +
				"                </div>\n" +
				"            </td>\n" +
				"        </tr>\n" +
				"        </tbody>\n" +
				"    </table>\n" +
				"</div>\n" +
				"</body>\n" +
				"</html>";
		// 发送邮件
		sendEmailUtil.sendEmail("邮箱验证码", html.replace("{0}", code), email);
	}
}
