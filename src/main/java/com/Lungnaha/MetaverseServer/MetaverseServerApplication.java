package com.Lungnaha.MetaverseServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Spring Boot 실행 시에 Tomcat을 활용해서 같이 실행
public class MetaverseServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetaverseServerApplication.class, args);
	}
	
	// 생성 과정 정리
	// 1. Domain에서 Data 형식 지정
	// 2. Repository 에서 생성된 Data 형식에 알맞는 기능 구현
	// 3. 생성된 Repository를 적절하게 활용하는 service 구현
	// 4. 해당 Service와 Repository를 연결해주는 Controller 구현
	// 5. Controller와 함께 Spring bean에 Service와 Repository를 올리기 위해 Configuration 구현
	// 6. Test code 작성을 통해서 해당 기능 확인 하기

}
