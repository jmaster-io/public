package jmaster.io.statisticservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

import jmaster.io.statisticservice.entity.Statistic;
import jmaster.io.statisticservice.repository.StatisticRepo;

@Service
public class StatisticService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StatisticRepo statisticRepo;

	@KafkaListener(id = "statisticGroup", 
			topics = "statistic")
	public void listen(Statistic statistic) {
		logger.info("Received: " + statistic.getMessage());
//		statisticRepo.save(statistic);
//		throw new RuntimeException();
	}

	@KafkaListener(id = "dltGroup", topics = "statistic-dlt")
	public void dltListen(Statistic statistic) {
		logger.info("Received statistic.DLT: " + statistic.getMessage());
		// save to database to re-send to queue
	}
}
