package com.wayming.codeland.service;

import com.wayming.codeland.pojo.eo.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author m969130721@163.com
 * @date 18-6-24 下午7:20
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
public class UserServiceTest {

//    @Autowired
    private UserService userService;
    @Test
    public void getUserByUsername() {
    String string ="http://localhost:8081/codeland/avatar/153085491122157.png";
        System.out.println(string.substring(string.lastIndexOf("/")));

        System.out.println(new Date(78986402).toLocaleString());
//        SysUser ming2 = userService.getUserByUsername("ming");
    }
}