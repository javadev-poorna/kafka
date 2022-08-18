package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.constants.AppConstants;
import com.example.demo.constants.Message;

@Service
public class KafKaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumer.class);

	@KafkaListener(topics = AppConstants.TOPIC_REQUESTS_ACK, groupId = AppConstants.GROUP_ID)
	public void ackConsumer(Message message) {
		LOGGER.info(String.format("Ack Message received At Appone -> %s", message.toString()));
	}

	@KafkaListener(topics = AppConstants.TOPIC_RESPONSES_NAME, groupId = AppConstants.GROUP_ID)
	public void responseConsumer(Message message) {
		LOGGER.info(String.format("Response Message received At Appone -> %s", message.toString()));
	}

}
