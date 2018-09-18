package com.wayming.codeland;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableSwagger2
@MapperScan("com.wayming.codeland.dao")
public class CodelandApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodelandApplication.class, args);
    }
}
