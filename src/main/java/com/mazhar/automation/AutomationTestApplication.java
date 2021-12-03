package com.mazhar.automation;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mazhar.automation.model.Country;
import com.mazhar.automation.model.CountryDataFormat;
import com.mazhar.automation.worker.DataSource;
import com.mazhar.automation.worker.ReadAllData;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class AutomationTestApplication {

	@Autowired
	private ReadAllData data;
	public static void main(String... args) {
		SpringApplication.run(AutomationTestApplication.class, args);
	}

	public void writeToXML(List<CountryDataFormat> countryDataFormats) throws IOException {
		XmlMapper xmlMapper = new XmlMapper();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		//ClassLoader classLoader = getClass().getClassLoader();
		File file = new File("C:\\Users\\mazhar\\Desktop\\files\\test"+System.currentTimeMillis()+".xml");
		xmlMapper.writeValue(byteArrayOutputStream, countryDataFormats);
		boolean exists = file.exists();
		if(!exists) {
			file.createNewFile();
		}
		try(OutputStream outputStream = new FileOutputStream(file)) {
			byteArrayOutputStream.writeTo(outputStream);
		}


	}



	@PostConstruct
	public void doTest() throws IOException {

	}

	//@Scheduled(fixedRate = 600000) //10 min
	public void scheduleTaskWithFixedRate() {
		try {
			doTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




}
