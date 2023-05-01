package com.rsm.scheduler;

import java.time.LocalDateTime;
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
	public void scheduledFixedRate() {
		log.info("Excuted scheduledFixedRate every 5 seconds {}", new Date());
	}

	@Scheduled(fixedDelay  = 5, timeUnit = TimeUnit.SECONDS)
	public void scheduledFixedDelay() {
		log.info("Excuted scheduledFixedDelay every 5 seconds {}", new Date());
	}

	@Scheduled(cron = "${scheduling.job.cron}")
	public void scheduledCron() {
		log.info("Excuted scheduledCron every 5 seconds {}", new Date());
	}

	@Scheduled(initialDelay = 2, fixedRate = 5,  timeUnit = TimeUnit.SECONDS)
	public void scheduledInitialDelay() {
		log.info("Excuted scheduledInitialDelay every 5 seconds {}", new Date());
	}

	@Scheduled(fixedRate = 3000)
	public void doSomething() {
		log.info("Scheduled job is running with thread: " + Thread.currentThread().getName() + " at time: "
				+ LocalDateTime.now());
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Scheduled(fixedRate = 3000)
	public void doSomethingElse() {
	    System.out.println("Other scheduled job is running with thread: " + Thread.currentThread().getName() +
	            " at time: " + LocalDateTime.now());
	    try {
	        Thread.sleep(5000L);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
}
