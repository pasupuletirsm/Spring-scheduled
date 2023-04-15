package com.rsm.scheduler;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledJob {
	
	Logger log = LoggerFactory.getLogger(ScheduledJob.class);
	
	@Scheduled(fixedRate = 5000)
	public void scheduledFixedRate() throws InterruptedException {
		log.info("Excuted scheduledFixedRate every 5 seconds", new Date());
	}
	
	@Scheduled(fixedDelay  = 5, timeUnit = TimeUnit.SECONDS)
	public void scheduledFixedDelay() throws InterruptedException {
		log.info("Excuted scheduledFixedDelay every 5 seconds", new Date());
	}
	
	@Scheduled(cron = "${scheduling.job.cron}")
	public void scheduledCron() throws InterruptedException {
		log.info("Excuted scheduledCron every 5 seconds", new Date());
	}

}
