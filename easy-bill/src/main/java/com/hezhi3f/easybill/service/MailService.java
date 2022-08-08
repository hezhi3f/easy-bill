package com.hezhi3f.easybill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public interface MailService {

    void sendVerifyMessage(String to, String code) throws MessagingException;


}
