package com.mazhar.automation;

import com.mazhar.automation.worker.AutomationExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;



@SpringBootApplication
@EnableScheduling
public class AutomationApplication {
	private final static Logger logger = LoggerFactory.getLogger(AutomationApplication.class);
	@Autowired
	private AutomationExecutor process;

	public static void main(String... args) {
		SpringApplication.run(AutomationApplication.class, args);
	}

	@Scheduled(fixedRate = 1296000000) //6hours
	public void scheduleTaskWithFixedRate() {
		logger.debug("Task start .......");
		process.doStart();
	}




}
