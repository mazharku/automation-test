package com.mazhar.automation;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mazhar.automation.model.Hotel;
import com.mazhar.automation.model.Student;
import com.mazhar.automation.model.Teacher;
import com.mazhar.automation.model.Weather;
import com.mazhar.automation.worker.ReadData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Arrays;

@SpringBootApplication
public class AutomationTestApplication {

	@Autowired
	private ReadData data;
	public static void main(String[] args) {
		SpringApplication.run(AutomationTestApplication.class, args);
	}

	/*public void writeToXML() throws IOException {
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
		teacher.setStudents(Arrays.asList(new Student("A",1,2),new Student("B",2,3)));
		return teacher;
	}*/


	@PostConstruct
	public void doTest() {
		Weather dhaka = data.getWeather("dhaka");
		System.out.println(dhaka);
	}

}
