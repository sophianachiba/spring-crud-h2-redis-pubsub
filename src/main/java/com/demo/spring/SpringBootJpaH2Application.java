package com.demo.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootJpaH2Application {


@Value("${spring.redis.host}")
private String redisHost;

@Value("${spring.redis.port}")
private Integer redisPort;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaH2Application.class, args);
	}

@Bean
JedisConnectionFactory jedisConnectionFactory() {
	RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHost, redisPort);
    return new JedisConnectionFactory(redisStandaloneConfiguration);
}

@Bean
public RedisTemplate<String, Object> redisTemplate() {
    final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
    template.setConnectionFactory(jedisConnectionFactory());
    template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
    return template;
}



}
