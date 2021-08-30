package com.Lungnaha.MetaverseServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Spring Boot 실행 시에 Tomcat을 활용해서 같이 실행
public class MetaverseServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetaverseServerApplication.class, args);
	}

}
