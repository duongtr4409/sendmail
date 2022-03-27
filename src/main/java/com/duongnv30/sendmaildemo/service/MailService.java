package com.duongnv30.sendmaildemo.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.web.multipart.MultipartFile;

import com.duongnv30.sendmaildemo.dto.DataMailDTO;
import com.duongnv30.sendmaildemo.model.MailDto;

public interface MailService {
	void sendHtmlMail(DataMailDTO dataMail, String templateName) throws MessagingException;
	boolean sendMail(MultipartFile files, MailDto mailDto);
	Boolean send(MimeMessage mail);
}
