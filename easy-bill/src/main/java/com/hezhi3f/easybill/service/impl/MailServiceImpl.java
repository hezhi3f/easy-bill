package com.hezhi3f.easybill.service.impl;

import com.hezhi3f.easybill.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {
    @Value("${spring.mail.username}")
    private String from;

    private static final String SUBJECT = "Easy-Bill邮箱验证";

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendVerifyMessage(String to, String code) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(SUBJECT);
        helper.setText("<h3>欢迎您使用此邮箱注册Easy-Bill，若不是您本人操作请忽略</h3><h3>验证码：</h3><h2>" + code + "</h2>", true);
        javaMailSender.send(message);
    }
}
