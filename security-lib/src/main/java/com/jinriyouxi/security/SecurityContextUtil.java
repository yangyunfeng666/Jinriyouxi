package com.jinriyouxi.security;

import com.jinriyouxi.common.constant.ResultCode;
import com.jinriyouxi.common.constant.ResultMsg;
import com.jinriyouxi.common.exception.ResponseException;
import com.jinriyouxi.security.domain.MyUserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 读取当前token认证消息
 */
public class SecurityContextUtil {
    private SecurityContextUtil() {
    }

    /**
     * 获取用户名字
     * @return
     */
    public static MyUserDetail currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof  MyUserDetail) {
                MyUserDetail myUserDetail = (MyUserDetail) principal;
                return myUserDetail;
            }
        }
        throw ResponseException.of(ResultCode.FAILURE, ResultMsg.INVALID_AUTHOR.getMsg());
    }
    /**
     * 获取用户名字
     * @return
     */
    public static String currentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal != null && principal instanceof  MyUserDetail) {
                MyUserDetail myUserDetail = (MyUserDetail) principal;
                return myUserDetail.getUserName();
            }
        }
        throw ResponseException.of(ResultCode.FAILURE,ResultMsg.INVALID_AUTHOR.getMsg());
    }
    /**
     * 获取用户id
     * @return
     */
    public static String currentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal != null && principal instanceof  MyUserDetail) {
                MyUserDetail myUserDetail = (MyUserDetail) principal;
                return myUserDetail.getId();
            }
        } else {
            throw ResponseException.of(ResultCode.FAILURE,ResultMsg.INVALID_AUTHOR.getMsg());
        }
        throw ResponseException.of(ResultCode.FAILURE,ResultMsg.INVALID_AUTHOR.getMsg());
    }

}
