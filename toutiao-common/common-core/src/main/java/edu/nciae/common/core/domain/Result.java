package edu.nciae.common.core.domain;

import lombok.Data;

import java.io.Serializable;

@Data
// 结果返回类型
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 通用返回码
     */
    private int code;

    /**
     * 通用返回消息
     */
    private String msg;

    /**
     * 结果对象
     */
    private T data;

    /**
     * 成功时候的调用
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    public static <T> Result<T> success(CodeMsgConstants codeMsg) {
        return new Result<T>(codeMsg);
    }

    public static <T> Result<T> success(CodeMsgConstants codeMsg, T data) {
        return new Result<T>(codeMsg, data);
    }

    /**
     * 失败时候的调用
     */
    public static <T> Result<T> error(CodeMsgConstants codeMsg) {
        return new Result<T>(codeMsg);
    }

    public static <T> Result<T> error(CodeMsgConstants codeMsg, T data) {
        return new Result<T>(codeMsg, data);
    }

    public Result(int code) {
        this.code = code;
    }

    @Deprecated
    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(T data) {
        this.data = data;
    }

    private Result(CodeMsgConstants codeMsg) {
        if (codeMsg != null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
    }

    private Result(CodeMsgConstants codeMsg, T data) {
        if (codeMsg != null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
        this.data = data;
    }

}
