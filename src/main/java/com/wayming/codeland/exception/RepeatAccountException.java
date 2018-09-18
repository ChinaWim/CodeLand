package com.wayming.codeland.exception;

/**
 * @author m969130721@163.com
 * @date 18-6-20 下午10:02
 */
public class RepeatAccountException extends ApplicationException {

    public RepeatAccountException(String message){
        super(message);
    }
    public RepeatAccountException(Integer exceptionStatus) {
        super(exceptionStatus,"账号重复异常");
    }

    public RepeatAccountException(Integer exceptionStatus,String message) {
        super(exceptionStatus,message);
    }


}
