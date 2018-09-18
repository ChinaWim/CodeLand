package com.wayming.codeland.service.impl;

import com.wayming.codeland.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author m969130721@163.com
 * @date 18-6-22 上午12:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private UserService userService;
    @Test
    public void listUser() {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("969130721@qq.com");
            helper.setTo("969130721@qq.com");
            helper.setSubject("CodeLand博客激活邮件");
            StringBuffer sb = new StringBuffer();
            sb.append("<h1>尊敬的xxxx你好</h1>")
                    .append("<p </p>")
                    .append("<p </p>");
            helper.setText(sb.toString(), true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(message);
    }

    @Test
    public void saveUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode1 = encoder.encode("m969130721");
        System.out.println(encode1);
        String encode2 = encoder.encode("m969130721");
        System.out.println(encode2);
        boolean flag = encoder.matches(encode1, encode2);
        System.out.println(flag);

//        SysUser ming = userService.getUserByUsername("ming");
//        System.out.println(ming.getRoleList());

    }
}