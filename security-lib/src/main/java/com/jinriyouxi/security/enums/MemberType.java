/**
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.jinriyouxi.security.enums;

/**
 * 账户类型: 个人 MEMBER， 商户：MERCHANT，代理商：PROXY
 *
 * @author Admin
 * @version $Id: SigningType.java 2018年3月7日 下午10:38:10 $
 */
public enum MemberType {

	/**
	 * 个人
	 */
	MEMBER("个人"), 
	
	/**
	 * 企业
	 */
	MERCHANT("企业"),

	BROKER("职业合伙人"),

	PARTNER("事业合伙人"),

	/**
	 * 代理商
	 */
	PROXY("代理商"),

	/**
	 * 供应商
	 */
	SUPPLIER("供应商"),

	/**
	 * 系统
	 */
	SYSTEM("系统");

	private String text;

	MemberType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
