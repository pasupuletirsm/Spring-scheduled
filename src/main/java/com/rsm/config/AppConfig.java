package com.rsm.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;


@Configuration
@EnableScheduling
public class AppConfig implements SchedulingConfigurer {
	org.slf4j.Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod="shutdown")
    public Executor taskExecutor() {
    	
        return Executors.newScheduledThreadPool(3);
    }
}