package com.wayming.codeland.exception;


import com.wayming.codeland.constant.RestStatusConstant;

/**
 * @author m969130721@163.com
 * @date 18-6-20 下午9:55
 */
public class ApplicationException extends RuntimeException {

    //异常状态码
    private  Integer exceptionStatus = RestStatusConstant.SERVER_EXCEPTION;

    public ApplicationException(String message) {
        super(message);
    }
    public ApplicationException(Integer exceptionStatus) {
        this.exceptionStatus = exceptionStatus;
    }
    public ApplicationException(Integer exceptionStatus,String message) {
        super(message);
        this.exceptionStatus = exceptionStatus;
    }

    public Integer getExceptionStatus() {
        return exceptionStatus;
    }

}
