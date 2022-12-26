package com.webbanhang.service.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.webbanhang.service.MailerService;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.webbanhang.jpa.model.MailInfo;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Service
public class MailerUtils implements MailerService {
 
	@Autowired
	JavaMailSender sender;

	@Autowired
	private Configuration config;

	@Override
	public void send(MailInfo mail) throws MessagingException {
		Map<String, Object> model = new HashMap<>();
		model.put("capcha",mail.getBody());
		model.put("body",mail.getBody1());
		model.put("email",mail.getTo());

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

		try{
			Template t = config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

			helper.setFrom(mail.getFrom());
			helper.setTo(mail.getTo());
			helper.setSubject(mail.getSubject());
			helper.setText(html, true);
			helper.setReplyTo(mail.getFrom());
		} catch (IOException | TemplateException e) {
			e.getMessage();
		}

		String[] cc = mail.getCc();
		if (cc != null && cc.length > 0) {
			helper.setCc(cc);
		}

		String[] bcc = mail.getBcc();
		if (bcc != null && bcc.length > 0) {
			helper.setBcc(bcc);
		}

		String[] attachments = mail.getAttachments();
		if (attachments != null && attachments.length > 0) {
			for (String path : attachments) {
				File file = new File(path);
				helper.addAttachment(file.getName(), file);
			}
		}

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				sender.send(message);
			}
		});
		t.start();
	}

	@Override
	public void send(String to, String subject, String body) throws MessagingException {
		// TODO Auto-generated method stub
		this.send(new MailInfo(to, subject, body));
	}

	List<MailInfo> list = new ArrayList<>();

	@Override
	public void queue(MailInfo mail) {
		// TODO Auto-generated method stub
		list.add(mail);
	}

	@Override
	public void queue(String to, String subject, String body) {
		// TODO Auto-generated method stub
		queue(new MailInfo(to, subject, body));
	}

	@Scheduled(fixedDelay = 1000)
	private void run() {
		while (!list.isEmpty()) {
			MailInfo mail = list.remove(0);
			try {
				this.send(mail);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public void sendPassword(String email,String capchas) throws MessagingException{
		// TODO Auto-generated method stub
		String body1 = "Quên mật khẩu bạn?";
		MailInfo mailInfo= new MailInfo();
		mailInfo.setTo(email);
		mailInfo.setSubject("Forgot You Password?");
		mailInfo.setBody(capchas);
		mailInfo.setBody1(body1);
		this.send(mailInfo);
	}
	
	@Override
	public void sendSignUp(String email,String capchas) throws MessagingException {
		// TODO Auto-generated method stub\
		String body1 = "Tạo tài khoản?";
		MailInfo mailInfo= new MailInfo();
		mailInfo.setTo(email);
		mailInfo.setSubject("Create A New Account?");
		mailInfo.setBody(capchas);
		mailInfo.setBody1(body1);
		this.send(mailInfo);
	}

}
