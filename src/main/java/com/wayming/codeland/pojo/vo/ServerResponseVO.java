package com.wayming.codeland.pojo.vo;


import com.wayming.codeland.constant.RestStatusConstant;

import java.io.Serializable;


/**
 * @author m969130721@163.com
 * @date 18-6-20 下午10:04
 */
public class ServerResponseVO implements Serializable {

    private Integer status;

    private String message;

    private Object data;


    private ServerResponseVO() {

    }

    private ServerResponseVO(Integer status) {
        this.status = status;
    }

    private ServerResponseVO(String message) {
        this.status = RestStatusConstant.SUCCESS;
        this.message = message;
    }

    private ServerResponseVO(Object data) {
        this.status = RestStatusConstant.SUCCESS;
        this.data = data;
    }

    private ServerResponseVO(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    private ServerResponseVO(String message, Object data) {
        this.status = RestStatusConstant.SUCCESS;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return RestStatusConstant.SUCCESS.equals(status);
    }

    public static ServerResponseVO sendSuccess(String message) {
        return new ServerResponseVO(message);

    }

    public static ServerResponseVO sendSuccess(String message, Object data) {
        return new ServerResponseVO(message, data);

    }

    public static ServerResponseVO sendSuccess(Object data) {
        return new ServerResponseVO(data);

    }

    public static ServerResponseVO sendFail(Integer status) {
        return new ServerResponseVO(status);
    }

    public static ServerResponseVO sendFail(Integer status, String message) {
        return new ServerResponseVO(status, message);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "ServerResponseVO{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
