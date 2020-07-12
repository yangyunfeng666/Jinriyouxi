package com.jinriyouxi.common.constant;

/**
 * @author ZC
 * @PACKAGE_NAME: com.fbpay.broker.common
 * @PROJECT_NAME: fbp-parent
 * @NAME: BaseException
 * @USER: Administrator
 * @DATE: 2020/5/24/10:46
 * @DAY_NAME_SHORT: 周日
 * @Description: 自定义异常类
 **/
@SuppressWarnings("serial")
public class BaseException extends RuntimeException {

    /**
     * 返回错误码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private ResultMsg msg;

    /**
     * 构造 （默认返回码：300）
     * @param msg
     * 提示信息
     */
    public BaseException(ResultMsg msg) {
        code = ResultCode.FAILURE.getCode();
        this.msg = msg;
    }

    /**
     * 构造
     *
     * @param code
     */
    public BaseException(ResultCode code) {
        super(code.getMsg().getMsg());
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    /**
     * 构造
     *
     * @param enumCode
     * @param msg
     */
    public BaseException(ResultCode enumCode, ResultMsg msg) {
        super(msg.getMsg());
        this.msg = msg;
        this.code = enumCode.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public ResultMsg getMsg() {
        return msg;
    }
}
