package com.jinriyouxi.common.constant;

public enum ResultMsg {
        /** 执行失败 */
        FAILURE("执行失败"),
        /** 执行成功 */
        SUCCESS("执行成功"),
        QUERY_FAIL("查询失败"),
        SEND_SUCCESS("发送成功"),
        SEND_FAIL("发送失败"),
        /** 需审核 */
        NEED_AUDIT("已提交审核"),
        /** 查询结果为空 */
        DATA_NOT_FOUND("查询结果为空"),
        /** 重复请求 */
        REPEATED_REQUEST("重复请求"),
        /** 邮箱格式错误 */
        EMAIL_FORMAT("邮箱格式错误"),
        /** 邮箱格式已存在 */
        EMAIL_EXIST("邮箱已存在"),
        /** 合伙人不存在 */
        BROKER_NO_EXIST("合伙人不存在"),
        /** 验证码异常 */
        VALID_UNUSUAL("验证码错误"),
        /** 验证码异常 */
        VALID_EMPTY("验证码不能为空"),
        /** 邀请人不存在 */
        INVITE_UNUSUAL("邀请人信息不存在"),
        /** 数据已存在 */
        DATA_EXIST("数据已存在"),
        /** 用户名或者密码错误 */
        INVALID_LOGIN("用户名或者密码错误"),
        /** 用户名不存在 */
        INVALID_USERNAME("用户名错误"),
        /** 用户错误 */
        INVALID_USER("用户错误"),

        /** 用户名字重复 */
        USER_NAME_IS_EXIST("用户名字重复"),
        /** 用户不存在 */
        USER_NOT_EXIST("用户不存在"),
        /** 用户存在多个 */
        USER_EXIST_MANY("用户存在多个"),
        /** 用户错误 */
        INVALID_AUTHOR("不合法的权限"),
        /**
         * 退出成功
         */
        USER_LOGOUT_SUCCESS("退出成功"),
        /** 用户错误 */
        MENU_URL_EXIST("菜单url已经存在了"),
        /** 菜单不存在 */
        MENU_NO_EXIST("菜单不存在"),
        /** 用户错误 */
        MENU_USE_IN_ROLE("菜单有角色在使用"),

        /** 有权限在页面使用 */
        PERMISSION_USED("有权限在页面使用"),
        /** 权限已经存在 */
        PERMISSION_EXIST("权限已经存在"),
        /** 权限不存在 */
        PERMISSION_NO_EXIST("权限不存在"),
        /** 权限不存在 */
        PERMISSION_MEHTOD_INVALID("权限方法名称不合法"),
        /** 请求参数错误 */
        INVALID_PARAM("请求参数错误"),
        /** 找不到请求的资源 */
        NOT_FOUND("找不到请求的资源"),
        /** 找不到请求的资源 */
        SHARE_UNUSUAL("分润异常"),
        /**商户信息不存在*/
        MERCHANT_EXIST("商户信息不存在"),
        /**服务不可达*/
        SERVICE_UNAVILABLE("服务不可达，请稍后重试"),
        /** 系统发生异常 */
        ERROR("系统发生异常"),
        /** 验证失败 */
        VERIFICATION_FAILURE("验证失败"),
        /** 未授权的访问 */
        UNAUTHORIZED("未授权的访问"),
        /** 无效的订单 */
        INVALID_ORDER("token过期"),
        /** 禁止访问 */
        FORBIDOM("禁止访问"),
        /** 手机号已存在 */
        MOBILE_USEED("手机号已存在,请更换手机号!"),
        /** 角色名字已经存在 */
        ADD_ROLE_NAME_ERROR("角色名字已经存在"),


        /** 角色不存在 */
        ROLE_NOT_EXIST("角色不存在"),
        /** 角色在页面中使用 */
        ROLE_USED_IN_MENU("角色在页面中使用"),
        /** 角色还有用户在使用 */
        ROLE_USED_IN_USER("角色还有用户在使用"),


        /** 添加成功 */
        INSERT_SUCCESS("添加成功"),
        /** 添加失败 */
        INSERT_FAIL("添加失败"),
        /** 修改成功 */
        UPDATE_SUCCESS("修改成功"),
        /** 修改失败 */
        UPDATE_FAIL("修改失败"),
        /** 删除成功 */
        DELETE_SUCCESS("删除成功"),
        /** 删除失败 */
        DELETE_FAIL("删除失败"),
        /** 修改cron表达式成功 */
        CRON_CHNAGE_SUCCESS("修改cron表达式成功"),


        /** 上传目录没有写权限 */
        FILE_UPLOAD_PATH_NOT_WRITE("上传目录没有写权限"),

        /** 文件格式错误 */
        FILE_UPLOAD_TYPE_ERROR("文件格式错误"),

        /** 文件大小超过限制 */
        FILE_UPLOAD_SIZE_MAX("文件大小超过限制"),

        /** 上传目录不存在 */
        FILE_UPLOAD_PATH_NOT_EXIST("上传目录不存在");

        private String msg;
        ResultMsg() {
        }

        public String getMsg() {
                return msg;
        }

        ResultMsg(String msg) {
            this.msg = msg;
        }
    }
