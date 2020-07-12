package com.jinriyouxi.common.constant;

import com.alibaba.fastjson.JSON;

/**
 * @author ZC
 * @PACKAGE_NAME: com.fbpay.broker.common
 * @PROJECT_NAME: fbp-parent
 * @NAME: ResultCode
 * @USER: Administrator
 * @DATE: 2020/5/24/10:39
 * @DAY_NAME_SHORT: 周日
 * @Description: 返回状态吗枚举类
 **/
public enum ResultCode {

    /** 执行成功 */
    SUCCESS(200, ResultMsg.SUCCESS),
    /** 执行失败 */
    FAILURE(300, ResultMsg.DATA_NOT_FOUND),

    /** 未授权的访问 */
    UNAUTHORIZED(401, ResultMsg.UNAUTHORIZED),
    /** 授权过期 */
    INVALID_ORDER(402, ResultMsg.INVALID_ORDER),
    /** 禁止访问 */
    FORBIDOM(403, ResultMsg.FORBIDOM);


    private  int code;

    /**
     * 提示信息
     */
    private  ResultMsg msg;

    private ResultCode(int code, ResultMsg msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 通过业务代码获取业务操作枚举
     * @param code 业务代码
     * @return 业务枚举
     */
    public static ResultCode getResultStatusEnum(int code) {
        for (ResultCode item : ResultCode.values()) {
            if (item.code == code) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public int getCode() {
        return code;
    }

    public ResultMsg getMsg() {
        return this.msg;
    }

    public void setMsg(ResultMsg msg) {
        this.msg = msg;
    }
}
