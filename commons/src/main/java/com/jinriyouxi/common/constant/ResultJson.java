package com.jinriyouxi.common.constant;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * @author ZC
 * @PACKAGE_NAME: com.fbpay.broker.common
 * @PROJECT_NAME: fbp-parent
 * @NAME: ResultJson
 * @USER: Administrator
 * @DATE: 2020/5/24/10:27
 * @DAY_NAME_SHORT: 周日
 * @Description: 定义返回结果集
 **/

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultJson<T> {

    /**
     * 操作代码(具体参考返回代码常量接口定义)
     */
    private Integer code;

    /**
     * 数据对象
     */
    private T data;

    /**
     * 提示消息
     */
    private String msg;

    public ResultJson() {
        this.code = ResultCode.SUCCESS.getCode();
    }

    /**
     * 构造函数
     *
     * @param code
     *            操作代码
     */
    private ResultJson(Integer code) {
        this.code = code;
    }

    /**
     * 构造函数
     *
     * @param code
     *            操作代码
     * @param data
     *            数据对象
     */
    private ResultJson(Integer code, T data) {
        this(code);
        this.data = data;
    }

    public static ResultJson of(ResultCode resultCode) {
        ResultJson resultJson = new ResultJson(resultCode);
        return resultJson;
    }



    public static ResultJson of_success(Object data) {
        ResultJson resultJson = new ResultJson(ResultCode.SUCCESS.getCode(),data);
        resultJson.setMsg(ResultMsg.SUCCESS);
        return resultJson;
    }

    public static ResultJson of_success(ResultMsg msg,Object data) {
        ResultJson resultJson = new ResultJson(ResultCode.SUCCESS.getCode(),data,msg);
        return resultJson;
    }

    public static ResultJson of_error(ResultMsg msg) {
        ResultJson resultJson = new ResultJson(ResultCode.FAILURE.getCode(),null,msg);
        return resultJson;
    }

    @Deprecated
    public static ResultJson of_error(String msg) {
        ResultJson resultJson = new ResultJson(ResultCode.FAILURE.getCode(),null,msg);
        return resultJson;
    }


    /**
     * 构造函数
     *
     * @param code
     *            操作代码
     * @param msg
     *            提示消息
     */
    private ResultJson(Integer code, ResultMsg msg) {
        this(code);
        this.msg = msg.getMsg();
    }

    /**
     * 构造函数
     *
     * @param code
     *            操作代码
     * @param msg
     *            提示消息
     */
    private ResultJson(Integer code, String msg) {
        this(code);
        this.msg = msg;
    }

    /**
     * 构造函数
     *
     * @param code
     *            操作代码
     * @param data
     *            数据对象
     * @param msg
     *            提示消息
     */
    private ResultJson(Integer code, T data, ResultMsg msg) {
        this(code, data);
        this.msg = msg.getMsg();
    }

    /**
     * 构造函数
     *
     * @param code
     *            操作代码
     * @param data
     *            数据对象
     * @param msg
     *            提示消息
     */
    private ResultJson(Integer code, T data, String msg) {
        this(code, data);
        this.msg = msg;
    }

    /**
     * 构造函数
     *
     * @param rs
     *            业务枚举
     */
    public ResultJson(ResultCode rs) {
        this(rs.getCode(), rs.getMsg());
    }

//    /**
//     * 构造函数
//     *
//     * @param rs
//     *            业务枚举
//     * @param data
//     *            数据对象
//     */
//    public ResultJson(ResultCode rs, T data) {
//        this(rs.getCode(), data, rs.getMsg());
//    }

    /**
     * 构造函数
     *
     * @param rs
     *            业务枚举
     * @param msg
     *            提示消息
     */
    public ResultJson(ResultCode rs, ResultMsg msg) {
        this(rs.getCode(), msg);
    }

    /**
     * 构造方法<br />
     * 异常返回封装（当service需要返回提示信息时返回BaseException类型异常，其他的为系统未知异常，直接提示系统异常）
     * @param ex
     *            异常对象
     */
    public ResultJson(Exception ex) {
        // 是自定义返回消息异常
        if (ex instanceof BaseException) {
            BaseException exception = ((BaseException) ex);
            this.code = exception.getCode();
            this.msg = exception.getMsg().getMsg();
        } else {
            this.code = ResultCode.FAILURE.getCode();
            this.msg = ResultCode.FAILURE.getMsg().getMsg();
        }
    }

    /**
     * 请求是否成功<br />
     * 操作代码为600时，表示操作成功，并返回true
     * @return 返回请求是否成功（true|false）
     */
    @JSONField(serialize = false)
    public boolean checkSuccess() {
        if (this.getCode() != null && this.getCode().intValue() == ResultCode.SUCCESS.getCode()) {
            return true;
        }
        return false;
    }

    /**
     * 请求是否失败<br />
     * 操作代码不为600时，表示操作失败，并返回true
     * @return 返回请求是否失败（true|false）
     */
    @JSONField(serialize = false)
    public boolean checkFail() {
        return !this.checkSuccess();
    }

    /**
     * 把Object的data参数json字符串转换为java对象<br />
     * 如果data参数为空，返回空（null）
     * @param clazz
     * 转换类型
     * @return
     */
    @JSONField(serialize = false)
    public <T> T toObject(Class<T> clazz) {
        if (this.getData() != null) {
            JSONObject jsonObject = (JSONObject) this.getData();
            return jsonObject.toJavaObject(clazz);
        }
        return null;
    }

    /**
     * 把Object的data参数json字符串转换为java集合<br />
     * 如果data参数为空，返回空（null）
     * @param clazz
     * 转换类型
     * @return
     */
    @JSONField(serialize = false)
    public <T> List<T> toObjectList(Class<T> clazz) {
        if (this.getData() != null) {
            JSONArray objectList = (JSONArray) this.getData();
            return objectList.toJavaList(clazz);
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public ResultJson setCode(ResultCode code) {
        this.code = code.getCode();
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultJson setData(T data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultJson setMsg(ResultMsg msg) {
        this.msg = msg.getMsg();
        return this;
    }
    public ResultJson setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

