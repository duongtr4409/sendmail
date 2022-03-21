package com.duongnv30.sendmaildemo.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duongnv30.sendmaildemo.constant.Const;
import com.duongnv30.sendmaildemo.dto.DataMailDTO;
import com.duongnv30.sendmaildemo.dto.sdi.ClientSdi;
import com.duongnv30.sendmaildemo.service.ClientService;
import com.duongnv30.sendmaildemo.service.MailService;

@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
    private MailService mailService;

    @Override
    public Boolean create(ClientSdi sdi) {
        try {
            DataMailDTO dataMail = new DataMailDTO();

            dataMail.setTo(sdi.getEmail());
            dataMail.setSubject(Const.SEND_MAIL_SUBJECT.CLIENT_REGISTER);

            Map<String, Object> props = new HashMap<>();
            props.put("name", sdi.getName());
            props.put("username", sdi.getUsername());
            String randomText = RandomStringUtils.randomAlphanumeric(8);
            props.put("password", randomText);
            dataMail.setProps(props);

            mailService.sendHtmlMail(dataMail, Const.TEMPLATE_FILE_NAME.CLIENT_REGISTER);
            return true;
        } catch (MessagingException exp){
            exp.printStackTrace();
        }
        return false;
    }

}
