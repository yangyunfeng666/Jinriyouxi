/**
 * Copyright (c) 2011-2019 All Rights Reserved.
 */
package com.jinriyouxi.gateway.config;

import java.time.Duration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 *
 *
 * @author Admin
 * @version $Id: RedisConfig.java 2019年11月1日 下午10:26:00 $
 */
@EnableCaching
@Configuration
public class RedisConfig {
	// 过期时间1天
	private Duration timeToLive = Duration.ofDays(1);

	@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().entryTtl(this.timeToLive)
				.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))
				.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer()))
				.disableCachingNullValues();
		return RedisCacheManager.builder(connectionFactory).cacheDefaults(config).transactionAware().build();
	}

	@Bean(name = "redisTemplate")
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		redisTemplate.setKeySerializer(keySerializer());
		redisTemplate.setHashKeySerializer(keySerializer());
		redisTemplate.setValueSerializer(valueSerializer());
		redisTemplate.setHashValueSerializer(valueSerializer());
		return redisTemplate;
	}

	private RedisSerializer<String> keySerializer() {
		return new StringRedisSerializer();
	}

	private RedisSerializer<Object> valueSerializer() {
		return new GenericJackson2JsonRedisSerializer();
	}
}
