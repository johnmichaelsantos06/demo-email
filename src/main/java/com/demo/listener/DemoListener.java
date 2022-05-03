package com.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.models.FeedbackInfo;
import com.demo.service.PromotionService;

@Service
public class DemoListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoListener.class);

	private static final String TOPIC = "demo-feedback";

	@Autowired
	private PromotionService service;
	
	@KafkaListener(topics = TOPIC)
	public void listen(FeedbackInfo info) {
		LOGGER.info("Received message: " + info);
		service.sendPromotion(info.getEmail());
	}
}
