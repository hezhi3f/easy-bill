package com.hezhi3f.easybill.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@SpringBootTest
public class MailServiceTest {
    @Autowired
    JavaMailSender javaMailSender;

    @Test
    void test() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("hezhi3f@foxmail.com");
        helper.setTo("2657520652@qq.com");
        helper.setSubject("[subject]今天天气真好");
        helper.setText("<h1>[text]Hello,world!</h1>", true);
        javaMailSender.send(mimeMessage);
        System.out.println("邮件成功发送");
    }

    @Test
    void ssssss() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        mimeMessage.setFrom("hezhi3f@foxmail.com");


        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("hezhi3f@foxmail.com");
        helper.setTo("2657520652@qq.com");
        helper.setSubject("[subject]今天天气真好");
        helper.setText("<h1>[text]Hello,world!</h1>", true);
        javaMailSender.send(mimeMessage);
        System.out.println("邮件成功发送");
    }

    @Test
    void sssfew() throws MessagingException {
        String from = "hezhi3f@foxmail.com";
        String to = "2657520652@qq.com";
        String SUBJECT = "Easy-Bill邮箱验证";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(SUBJECT);
        helper.setText("<h3>欢迎您使用此邮箱注册Easy-Bill，若不是您本人操作请忽略</h3><h3>验证码：</h3><h2>" + 341243 + "</h2>", true);
        javaMailSender.send(message);
    }
}
