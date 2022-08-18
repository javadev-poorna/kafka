package com.example.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.example.demo.constants.AppConstants;

@Configuration
public class KafkaTopicConfig {

	
	@Bean
    public NewTopic requestsTopic(){
        return TopicBuilder.name(AppConstants.TOPIC_REQUESTS_NAME)
                .build();
    }
	
	@Bean
    public NewTopic requestsAckTopic(){
        return TopicBuilder.name(AppConstants.TOPIC_REQUESTS_ACK)
                .build();
    }
	
	@Bean
    public NewTopic responsesTopic(){
        return TopicBuilder.name(AppConstants.TOPIC_RESPONSES_NAME)
                .build();
    }
}
