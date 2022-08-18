package com.example.demo.controller;

import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.KafkaProducer;
import com.example.demo.constants.AppConstants;
import com.example.demo.constants.Message;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {

	private KafkaProducer kafkaProducer;

    public KafkaProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
    	Message msg = new Message();
    	msg.setMessage(message);
    	msg.setId(new Random().nextInt());
        kafkaProducer.sendMessage(msg, AppConstants.TOPIC_REQUESTS_NAME);
        return ResponseEntity.ok("Message sent to kafka topic Msg : "+msg.toString());
    }
	
	
}
