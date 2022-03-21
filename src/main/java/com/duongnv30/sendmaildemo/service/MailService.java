package com.duongnv30.sendmaildemo.service;

import javax.mail.MessagingException;

import com.duongnv30.sendmaildemo.dto.DataMailDTO;

public interface MailService {
	void sendHtmlMail(DataMailDTO dataMail, String templateName) throws MessagingException;
}
