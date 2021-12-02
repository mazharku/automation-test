package com.mazhar.automation;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mazhar.automation.model.Teacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.*;

@SpringBootApplication
public class AutomationTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomationTestApplication.class, args);
	}

	@PostConstruct
	public void writeToXML() throws IOException {
		XmlMapper xmlMapper = new XmlMapper();
		Teacher teacher = getDate(); // test data
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File("C:\\Users\\mazhar\\Desktop\\files\\test.xml");
		xmlMapper.writeValue(byteArrayOutputStream, teacher);
		boolean exists = file.exists();
		if(!exists) {
			file.createNewFile();
		}
		try(OutputStream outputStream = new FileOutputStream(file)) {
			byteArrayOutputStream.writeTo(outputStream);
		}


	}

	private Teacher getDate() {
		Teacher teacher = new Teacher();
		teacher.setName("A");
		teacher.setSubject("cse");
		return teacher;
	}

}
