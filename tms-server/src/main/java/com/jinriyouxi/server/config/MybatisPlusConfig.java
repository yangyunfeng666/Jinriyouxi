/**
 * Copyright (c) 2011-2019 All Rights Reserved.
 */
package com.jinriyouxi.server.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 *
 * @author Admin
 * @version $Id: MybatisPlusConfig.java 2019年5月28日 下午5:16:50 $
 */
@Configuration
@EnableTransactionManagement
public class MybatisPlusConfig {

	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor().setDbType(DbType.MYSQL);
	}

	@Bean
	public IKeyGenerator mysqlKeyGenerator() {
		return new IKeyGenerator() {
			@Override
			public String executeSql(String incrementerName) {
				return "SELECT " + incrementerName;
			}
		};
	}
}
