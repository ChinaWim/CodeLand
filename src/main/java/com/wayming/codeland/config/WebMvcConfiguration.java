package com.wayming.codeland.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author m969130721@163.com
 * @date 18-6-20 下午3:52
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public  void addInterceptors(InterceptorRegistry registry) {
    }

    @Value("${file.location.path}")
    private String fileLocationPath;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test").setViewName("test");

        registry.addViewController("/").setViewName("redirect:/index");
        registry.addViewController("/user/loginPage").setViewName("login");
        registry.addViewController("/user/registerPage").setViewName("register");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
////        registry.addResourceHandler("file/**").addResourceLocations("file:" + fileLocationPath + "/");
//    }


}
