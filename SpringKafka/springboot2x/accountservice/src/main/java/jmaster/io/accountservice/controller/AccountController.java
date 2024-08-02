package jmaster.io.accountservice.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.core.MessageReceivingOperations;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jmaster.io.accountservice.model.AccountDTO;
import jmaster.io.accountservice.model.MessageDTO;
import jmaster.io.accountservice.model.StatisticDTO;
import jmaster.io.accountservice.repo.AccountRepo;
import jmaster.io.accountservice.repo.MessageRepo;
import jmaster.io.accountservice.repo.StatisticRepo;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
	
	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	MessageRepo messageRepo;
	
	@Autowired
	StatisticRepo statisticRepo;

	@PostMapping("/new")
	public AccountDTO create(@RequestBody AccountDTO account) {
		StatisticDTO stat = new StatisticDTO("Account " + account.getEmail() + " is created", new Date());
		stat.setStatus(false);
		
		// send notificaiton
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setTo(account.getEmail());
		messageDTO.setToName(account.getName());
		messageDTO.setSubject("Welcome to JMaster.io");
		messageDTO.setContent("JMaster is online learning platform.");
		messageDTO.setStatus(false);
		
		accountRepo.save(account);
		messageRepo.save(messageDTO);
		statisticRepo.save(stat);

//		for (int i = 0; i < 100; i++) 
//			kafkaTemplate.send("notification", messageDTO).addCallback(new KafkaSendCallback<String, Object>() {
//				@Override
//				public void onFailure(KafkaProducerException ex) {
//					// handle fail, save db event failed
//					ex.printStackTrace();
//				}
//				@Override
//				public void onSuccess(SendResult<String, Object> result) {
//					// handle success
//					System.out.println(result.getRecordMetadata().partition());
//				}
//			});
//			
//		kafkaTemplate.send("statistic", stat);

		return account;
	}
}
