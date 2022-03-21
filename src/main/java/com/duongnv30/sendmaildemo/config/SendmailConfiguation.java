package com.duongnv30.sendmaildemo.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class SendmailConfiguation {
	
	@Value("${mailServer.host:smtp.gmail.com}")
	private String host;
	
	@Value("${mailServer.port:587}")
	private Integer port;
	
	@Value("${mailServer.email:nvduong216@gmail.com}")
	private String email;
	
	@Value("${mailServer.password:duongvan98}")
	private String password;
	
	@Value("${mailServer.protocol:smtp}")
	private String protocol;
	
	@Value("${mailServer.isSSL:false}")
	private String isSSL;
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		
		javaMailSenderImpl.setHost(this.host);
		javaMailSenderImpl.setPort(this.port);
		
		javaMailSenderImpl.setUsername(this.email);
		javaMailSenderImpl.setPassword(this.password);
		javaMailSenderImpl.setDefaultEncoding("UTF-8");
		
		Properties props = javaMailSenderImpl.getJavaMailProperties();
		props.put("mail.transport.protocol", this.protocol);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.enable", isSSL);
        props.put("mail.smtp.from", email);
        props.put("mail.debug", "true");
		
		return javaMailSenderImpl;
	}
}
