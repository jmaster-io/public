package jmaster.io.accountservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jmaster.io.accountservice.model.MessageDTO;
import jmaster.io.accountservice.model.StatisticDTO;
import jmaster.io.accountservice.repo.MessageRepo;
import jmaster.io.accountservice.repo.StatisticRepo;

@Component
public class PollingService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;

	@Autowired
	MessageRepo messageRepo;

	@Autowired
	StatisticRepo statisticRepo;

	@Scheduled(fixedDelay = 1000)
	public void producer() {
		List<MessageDTO> messageDTOs = messageRepo.findByStatus(false);

		for (MessageDTO messageDTO : messageDTOs) {
			kafkaTemplate.send("notification", messageDTO).addCallback(new KafkaSendCallback<String, Object>() {
				@Override
				public void onFailure(KafkaProducerException ex) {
					// handle fail, save db event failed
					logger.error("FAIL ", ex);
				}

				@Override
				public void onSuccess(SendResult<String, Object> result) {
					// handle success
					logger.error("SUCCESS ");

					messageDTO.setStatus(true);// success
					messageRepo.save(messageDTO);
				}
			});
		}

		List<StatisticDTO> statisticDTOs = statisticRepo.findByStatus(false);
		for (StatisticDTO statisticDTO : statisticDTOs) {
			kafkaTemplate.send("statistic", statisticDTO).addCallback(new KafkaSendCallback<String, Object>() {
				@Override
				public void onFailure(KafkaProducerException ex) {
					// handle fail, save db event failed
					logger.error("FAIL ", ex);
				}

				@Override
				public void onSuccess(SendResult<String, Object> result) {
					// handle success
					logger.error("SUCCESS ");

					statisticDTO.setStatus(true);// success
					statisticRepo.save(statisticDTO);
				}
			});
		}
	}
	
	@Scheduled(fixedDelay = 60000)
	public void delete() {
		List<MessageDTO> messageDTOs = messageRepo.findByStatus(true);
		messageRepo.deleteAllInBatch(messageDTOs);
		
		List<StatisticDTO> statisticDTOs = statisticRepo.findByStatus(true);
		statisticRepo.deleteAllInBatch(statisticDTOs);
	}

}
