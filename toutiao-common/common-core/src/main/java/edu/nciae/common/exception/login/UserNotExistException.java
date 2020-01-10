package edu.nciae.common.exception.login;

import edu.nciae.common.exception.BaseException;

public class UserNotExistException extends BaseException {

    /**
     * 所属模块
     */

    private String module;
    /**
     * 错误码
     */
    private String code;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    /**
     * 错误消息
     */
    private String defaultMessage;

    public UserNotExistException(String module, String code, Object[] args, String defaultMessage) {
        super(module, code, args, defaultMessage);
    }

    public UserNotExistException(String module, String defaultMessage) {
        this(module, null, null, defaultMessage);
    }

    @Override
    public String getMessage() {
        return defaultMessage;
    }

}
