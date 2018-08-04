package com.wayming.codeland.constant;

/**
 * controller接口状态常量
 *
 * @author m969130721@163.com
 * @date 18-6-20 下午8:21
 */
public class RestStatusConstant {

    /**
     * 标准http状态
     */

    public static final Integer SUCCESS = 200;

    public static final Integer INVALID_REQUEST = 400;

    public static final Integer UNAUTHORIZED = 401;

    public static final Integer NOT_FOUND = 404;

    public static final Integer SERVER_EXCEPTION = 500;

    /**
     * 以下为自定义异常(从9000开始排列)
     */

    // 登录账号或者密码错误
    public static final Integer ACCOUNT_OR_PASSWORD_ERROR = 9000;

    //Token校验失败
    public static final Integer TOKEN_ERROR = 9001;

    //登录账号已经存在
    public static final Integer EXISTED_USERNAME = 9002;

    //邮箱发送异常
    public static final Integer EMAIL_ERROR = 9003;

    //无效的激活码
    public static final Integer INVALID_ACTIVE_CODE = 9004;

    //上传文件异常
    public static final Integer UPLOAD_FILE_ERROR = 9005;

    //密码错误
    public static final Integer PASSWORD_ERROR = 9006;


}
