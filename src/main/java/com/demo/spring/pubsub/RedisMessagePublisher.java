package com.demo.spring.pubsub;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;


public class RedisMessagePublisher implements MessagePublisher {

    private RedisTemplate<String, Object> redisTemplate;

    private ChannelTopic topic;

    public RedisMessagePublisher() {
    }

    public RedisMessagePublisher(
      RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
      this.redisTemplate = redisTemplate;
      this.topic = topic;
    }

    public void publish(String s) {
        redisTemplate.convertAndSend(topic.getTopic(), s);
    }

    
}
