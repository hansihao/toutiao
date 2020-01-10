package edu.nciae.common.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CodeMsgConstants {
    private int code;
    private String msg;

    /**
     * 正确码
     */
    public static CodeMsgConstants SUCCESS = new CodeMsgConstants(200, "服务success");

    //错误码
    public static CodeMsgConstants FAIL = new CodeMsgConstants(500, "服务异常");

    /**
     * 用户
     */
    public static CodeMsgConstants ARGS_ERROR = new CodeMsgConstants(400, "参数错误");

    public static CodeMsgConstants USER_NOTEXIST = new CodeMsgConstants(401, "用户不存在");

    public static CodeMsgConstants USER_STATUSERROR = new CodeMsgConstants(402, "用户账户异常");

    public static CodeMsgConstants ARGS_NOTEXIST = new CodeMsgConstants(403, "缺少必要参数");

    public static CodeMsgConstants FOLLOW_NOTEXIST = new CodeMsgConstants(404, "暂无关注");

    public static CodeMsgConstants FANS_NOTEXIST = new CodeMsgConstants(405, "暂无粉丝");
}
