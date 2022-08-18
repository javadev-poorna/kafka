package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.constants.AppConstants;
import com.example.demo.constants.Message;

@Service
public class KafKaConsumer {

	@Autowired
	private KafkaProducer kafkaProducer;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumer.class);

    @KafkaListener(topics = AppConstants.TOPIC_REQUESTS_NAME,
                    groupId = AppConstants.GROUP_ID)
    public void consume(Message message) throws InterruptedException{
        LOGGER.info(String.format("Message received In App two-> %s", message.toString()));
        message.setStatus("ACK");
        kafkaProducer.sendMessage(message , AppConstants.TOPIC_REQUESTS_ACK);
        Thread.sleep(5000l);
        message.setStatus("SUCCESS");
        message.setCode(200);
        kafkaProducer.sendMessage(message , AppConstants.TOPIC_RESPONSES_NAME);
        
    }
}
