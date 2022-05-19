package com.demo.spring.pubsub;

import com.demo.spring.jpa.h2.repository.TutorialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RedisMessageSubscriber implements MessageListener {
    
    @Autowired
	TutorialRepository tutorialRepository;

    public void onMessage(Message message, byte[] pattern) {
        Long l = Long.valueOf(message.toString());
        tutorialRepository.deleteById(l);
    }
}
