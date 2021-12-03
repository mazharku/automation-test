package com.mazhar.automation;

import com.mazhar.automation.worker.AutomationExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
@EnableScheduling
public class AutomationApplication {

	@Autowired
	private AutomationExecutor process;

	public static void main(String... args) {
		SpringApplication.run(AutomationApplication.class, args);
	}





	@PostConstruct
	public void doTest() throws IOException {

	}

	@Scheduled(fixedRate = 600000) //10 min
	public void scheduleTaskWithFixedRate() {
		process.doStart();
	}




}
