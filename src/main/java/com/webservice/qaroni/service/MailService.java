package com.webservice.qaroni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.qaroni.mail.MailManager;

@Service
public class MailService {
	
	@Autowired
	MailManager mailManager;
	
	public void sendMessageUser(String email, String message) {
		mailManager.sendMessage(email, message);
	}

}
