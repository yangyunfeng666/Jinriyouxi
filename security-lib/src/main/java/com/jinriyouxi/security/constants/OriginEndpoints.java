package com.jinriyouxi.security.constants;

/**
 * @date 2018-11-26 20:32
 */
public class OriginEndpoints {
    /**
     * 授权端点
     */
    public static final String OAUTH_AUTHORIZE_URI = "/oauth/authorize";

    /**
     * 获取令牌端点
     */
    public static final String OAUTH_TOKEN_URI = "/oauth/token";

    /**
     * 校验token合法性端点
     */
    public static final String OAUTH_CHECK_TOKEN = "/oauth/check_token";

    /**
     * 用户确认授权端点，我们用的模式不会用到这个
     */
    public static final String OAUTH_CONFIRM_ACCESS = "/oauth/confirm_access";

    /**
     * 授权失败(展示)端点
     */
    public static final String OAUTH_OAUTH_ERROR = "/oauth/error";

    /**
     * 获取公钥端点，用jwt的作为 tokenStore的时候能用到
     */
    public static final String OAUTH_TOKEN_KEY = "/oauth/token_key";
}
