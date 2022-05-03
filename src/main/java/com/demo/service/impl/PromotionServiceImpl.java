package com.demo.service.impl;

import java.io.File;
import java.net.URL;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.demo.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PromotionServiceImpl.class);

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendPromotion(String email) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(email);
			helper.setSubject("Promotion");

			URL url = this.getClass().getClassLoader().getResource("image/lazada-voucher.jpg");

			File file = new File(url.getFile());
			
			FileSystemResource fileSystemResource = new FileSystemResource(file);
			
			helper.addInline("promotion", fileSystemResource);
			
			mailSender.send(mimeMessage);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

	}

}
