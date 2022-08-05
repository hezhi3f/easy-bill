package com.hezhi3f.easybill.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void verifyEmail(String email, String code) {
        //MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        //javaMailSender.send(mimeMessage);
    }


}
