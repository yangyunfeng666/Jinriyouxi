package com.jinriyouxi.security.constants;



/**
 * @author zhangwen@reconova.com
 * @date 2018-11-26 20:32
 */
public class UfaceEndpoints {

    public static final String URL_PREFIX = "";
    /**
     * 授权端点
     */
    public static final String OAUTH_AUTHORIZE_URI = URL_PREFIX + "/auth/authorize";

    /**
     * 获取令牌端点
     */
    public static final String OAUTH_TOKEN_URI = URL_PREFIX + "/auth/token";

    /**
     * 校验token合法性端点
     */
    public static final String OAUTH_CHECK_TOKEN = URL_PREFIX + "/auth/check_token";

    /**
     * 用户确认授权端点，我们用的模式不会用到这个
     */
    public static final String OAUTH_CONFIRM_ACCESS = URL_PREFIX + "/auth/confirm_access";

    /**
     * 授权失败(展示)端点
     */
    public static final String OAUTH_OAUTH_ERROR = URL_PREFIX + "/auth/error";

    /**
     * 获取公钥端点，用jwt的作为 tokenStore的时候能用到
     */
    public static final String OAUTH_TOKEN_KEY = URL_PREFIX + "/auth/token_key";

    /**
     * 取消授权
     */
    public static final String OAUTH_REVOKE = URL_PREFIX + "/token/revoke";
}
