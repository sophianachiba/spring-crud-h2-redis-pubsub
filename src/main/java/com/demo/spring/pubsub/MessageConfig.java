package com.demo.spring.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

@Configuration
public class MessageConfig {

@Autowired
JedisConnectionFactory jedisCon;

@Autowired
RedisTemplate<String, Object> redisTemp;

@Autowired
ChannelTopic topic;

@Autowired
MessageListener listener;
  

@Bean
RedisMessageListenerContainer redisContainer() {
    RedisMessageListenerContainer container 
      = new RedisMessageListenerContainer(); 
    container.setConnectionFactory(jedisCon); 
    container.addMessageListener(listener, topic); 
    return container; 
}

@Bean
MessagePublisher redisPublisher() {
    return new RedisMessagePublisher(redisTemp, topic);
}

@Bean
ChannelTopic topic() {
    return new ChannelTopic("messageQueue");
}


}
