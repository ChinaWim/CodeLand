package com.wayming.codeland.config;

import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/** jsonp解决跨域问题，但只能解决get请求
 * @author m969130721@163.com
 * @date 18-7-6 下午12:36
 */
//@ControllerAdvice
public class JsonpConfiguration extends AbstractJsonpResponseBodyAdvice {

    public JsonpConfiguration(){
        super("callback");
    }
}
