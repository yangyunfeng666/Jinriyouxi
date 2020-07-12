/**
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.jinriyouxi.security.enums;

/**
 * 页面类型: 个人 MEMBER， 商户：MERCHANT，代理商：PROXY
 *
 * @author Admin
 * @version $Id: SigningType.java 2018年3月7日 下午10:38:10 $
 */
public enum MenuType {



	ADMIN("系统超级管理员"),

	PARTNER("职业合伙人"),
	/**
	 * 代理商
	 */
	PROXY("代理商"),
	/**
	 * 供应商
	 */
	MERCHANT("供应商"),
	/**
	 * 系统
	 */
	SYSTEM("系统");

	private String text;

	MenuType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
