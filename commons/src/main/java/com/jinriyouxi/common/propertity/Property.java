/**
 * Copyright (c) 2011-2014 All Rights Reserved.
 */
package com.jinriyouxi.common.propertity;

/**
 * 
 * @author Admin
 * @version $Id: Property.java 2014年8月27日 下午6:28:46 $
 */
public class Property {

    private static java.util.Properties property = null;

    private Property() {
    }

    public static void init(java.util.Properties props) {
        property = props;
    }
    
    public static void setProperty(String key, Object value) {
        property.put(key, value);
    }

    public static String getProperty(String key) {
        return property.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return property.getProperty(key, defaultValue);
    }

}
