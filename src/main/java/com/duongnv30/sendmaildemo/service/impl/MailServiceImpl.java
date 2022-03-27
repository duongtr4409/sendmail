package com.duongnv30.sendmaildemo.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.duongnv30.sendmaildemo.dto.DataMailDTO;
import com.duongnv30.sendmaildemo.model.MailDto;
import com.duongnv30.sendmaildemo.service.MailService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private SpringTemplateEngine templateEngine;
	
	@Autowired
	ServletContext context;
	
	public static Queue<MimeMessage> listMail = new LinkedList<MimeMessage>();

	@Override
	public void sendHtmlMail(DataMailDTO dataMail, String templateName) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

		Context context = new Context();
		context.setVariables(dataMail.getProps());

		String html = templateEngine.process(templateName, context);

		helper.setTo(dataMail.getTo());
		helper.setSubject(dataMail.getSubject());
		helper.setText(html, true);

		mailSender.send(message);
	}

	@Override
	public boolean sendMail(MultipartFile files, MailDto mailDto) {
		String path = context.getRealPath("uploads");
		File file = new File("D:\\" /*+ UUID.randomUUID()*/ + files.getOriginalFilename());
		try {
			files.transferTo(file);
			mailDto.getAttachmentFile().add(file);
			listMail.offer(createMineMessage(mailDto));
//			file.delete();
			return true;
		} catch (IllegalStateException | IOException | MessagingException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	private MimeMessage createMineMessage(MailDto mailDto) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		if(mailDto.getTemplateName() != null && !mailDto.getTemplateName().trim().isEmpty()) {
			Context context = new Context();
			context.setVariables(mailDto.getProps());
			String html = templateEngine.process(mailDto.getTemplateName(), context);
			
			helper.setText(html, true);
		}else {
			helper.setText(mailDto.getContent(), true);
		}

		helper.setSubject(mailDto.getSubject());
		helper.setFrom(mailDto.getEmailAddressFrom());
		helper.setTo(mailDto.getEmailAddressTo().toArray(new String[0]));
		helper.setCc(mailDto.getEmailAddressCC().toArray(new String[0]));
		helper.setBcc(mailDto.getEmailAddressBCC().toArray(new String[0]));
		helper.setReplyTo(mailDto.getEmailAddressFrom());
		mailDto.getAttachmentFile().stream().forEach( ele -> {
			try {
				helper.addAttachment(ele.getName(), ele);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		});
		return message;
	}

	@Override
	public Boolean send(MimeMessage mail) {
		try {			
			mailSender.send(mail);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
