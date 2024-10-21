package cn.qht2005.ylEcosphere.utils;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SendEmailUtil {
	@Autowired
	JavaMailSender javaMailSender;
	@Value("${spring.mail.username}")
	private String sender;
	public void sendEmail(String title, String content,  String receiver) throws Exception {
		try {
			// 创建一个邮件消息
			MimeMessage message = javaMailSender.createMimeMessage();
			// 创建 MimeMessageHelper
			MimeMessageHelper helper = new MimeMessageHelper(message, false);
			// 发件人邮箱和名称
			helper.setFrom(sender, "悦绿生态圈");
			// 收件人邮箱
			helper.setTo(receiver);
			// 邮件标题
			helper.setSubject(title);
			// 邮件正文，第二个参数表示是否是HTML正文
			helper.setText(content, true);
			// 发送
			javaMailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
