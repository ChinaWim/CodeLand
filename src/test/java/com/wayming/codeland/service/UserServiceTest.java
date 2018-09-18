package com.wayming.codeland.service;

import com.wayming.codeland.pojo.eo.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author m969130721@163.com
 * @date 18-6-24 下午7:20
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
public class UserServiceTest {

    public static ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();

//    @Autowired
    private UserService userService;
    @Test
    public void getUserByUsername() {

    }
}

class TestClass{

    public static void main(String[] args) throws InterruptedException {
        UserServiceTest.threadLocal.set(new HashMap<>());
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10,10,100L,TimeUnit.HOURS,new ArrayBlockingQueue<Runnable>(10));

        threadPoolExecutor.execute(()->{
            ThreadLocal<Map<String, Object>> threadLocal = UserServiceTest.threadLocal;
            System.out.println(threadLocal.get() +"前:"+Thread.currentThread().getName());
            threadLocal.set(new HashMap<>());
            System.out.println(threadLocal.get()+"后"+Thread.currentThread().getName());
            System.out.println(threadLocal.get().hashCode());

        });
        TimeUnit.SECONDS.sleep(5);
        threadPoolExecutor.execute(()->{
            ThreadLocal<Map<String, Object>> threadLocal = UserServiceTest.threadLocal;
            System.out.println(threadLocal.get().hashCode());
        });
        threadPoolExecutor.shutdown();
    }

}