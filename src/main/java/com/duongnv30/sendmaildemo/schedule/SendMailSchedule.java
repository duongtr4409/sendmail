package com.duongnv30.sendmaildemo.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.duongnv30.sendmaildemo.service.MailService;
import com.duongnv30.sendmaildemo.service.impl.MailServiceImpl;

@Component
public class SendMailSchedule {
	
	@Autowired
	private MailService mailService;
	
	@Scheduled(fixedRate = 60000)	// 60s
	void run() {
		while(!MailServiceImpl.listMail.isEmpty()) {
			Boolean resultSend = mailService.send(MailServiceImpl.listMail.poll());
			System.out.println("Result Send Mail: " + resultSend);
		}
	}
}
