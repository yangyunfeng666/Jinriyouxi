/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.jinriyouxi.security.enums;

/**
 *
 *
 * @author Admin
 * @version $Id: MemberStatus.java 2016年1月15日 下午9:40:24 $
 */
public enum MemberStatus {

	INIT("待激活"), ENABLE("启用"), UNABLE("停用"), LOCK("锁定"), CANCEL("注销");

    private String text;

    MemberStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
