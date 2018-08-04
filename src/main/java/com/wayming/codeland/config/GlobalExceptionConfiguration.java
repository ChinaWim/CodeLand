package com.wayming.codeland.config;

import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.constant.RestStatusConstant;
import com.wayming.codeland.exception.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**统一全局异常
 * @author m969130721@163.com
 * @date 18-6-20 下午3:54
 */
@ControllerAdvice
public class GlobalExceptionConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionConfiguration.class);
    private static String ERROR_VIEW = "500";

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object solveException(HttpServletRequest request, HttpServletResponse response,Exception exception){
        LOGGER.error(request.getRequestURI()+"请求地址,异常信息 message:",exception);
        //如果是ajax请求返回json
        if (isAjaxRequest(request)) {
            Integer exceptionStatus = RestStatusConstant.SERVER_EXCEPTION;
            if (exception instanceof ApplicationException){
                ApplicationException applicationException = (ApplicationException)exception;
                exceptionStatus = applicationException.getExceptionStatus();
            }
            return ServerResponseVO.sendFail(exceptionStatus,exception.getMessage());
        }

        //返回错误页面
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",exception.getMessage());
        modelAndView.addObject("uri","请求地址："+request.getRequestURI());
        modelAndView.setViewName(ERROR_VIEW);
        return modelAndView;
    }
    public boolean isAjaxRequest(HttpServletRequest request){
        String header = request.getHeader("X-Requested-With");
        return (header!= null && "XMLHttpRequest".equals(header));
    }

}
