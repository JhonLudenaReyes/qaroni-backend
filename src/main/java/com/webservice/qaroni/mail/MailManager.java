package com.webservice.qaroni.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class MailManager {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String sender;
	
	public void sendMessage(String email, String messageEmail) {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			message.setSubject("Email qaroni");
			
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(email);
			helper.setText(messageEmail);
			helper.setFrom(sender);
			javaMailSender.send(message);
			
		} catch (MessagingException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

}
