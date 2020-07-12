package com.jinriyouxi.common.exception;


import com.jinriyouxi.common.constant.ResultCode;

/**
 * @date 业务异常 父类。在restful 接口层使用切面捕获，统一封装输出。
 */
public class ResponseException extends RuntimeException {
    private static final long serialVersionUID = -721489076559710085L;
    /**
     * 错误代码
     */
    protected ResultCode code;
    /**
     * 错误信息
     */
    protected String message;

    private Throwable cause;

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    public static ResponseException of(ResultCode code) {
        ResponseException ufaceException = new ResponseException();
        ufaceException.setCode(code);
        ufaceException.setMessage(code.getMsg().getMsg());
        return ufaceException;
    }

    public static ResponseException of(ResultCode code, String message) {
        ResponseException ufaceException = new ResponseException();
        ufaceException.setCode(code);
        ufaceException.setMessage(message);
        return ufaceException;
    }

    public static ResponseException ofDetail(ResultCode code, Object... params) {
        String message = String.format(code.getMsg().getMsg(), params);
        ResponseException ufaceException = new ResponseException();
        ufaceException.setCode(code);
        ufaceException.setMessage(message);
        return ufaceException;
    }

    public static ResponseException of(ResultCode code, Throwable cause) {
        ResponseException ufaceException = new ResponseException();
        ufaceException.setCode(code);
        ufaceException.setCause(cause);
        ufaceException.setMessage("todo need get from db/properties");
        return ufaceException;
    }

}
