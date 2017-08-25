package com.leicht;

import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.leicht.spring.domain.Journal;
import com.leicht.spring.repository.JournalRepository;
import com.leicht.spring.service.JournalService;

@SpringBootApplication
public class SpringBootJournalApplication {
	
	 private static final Logger log = LoggerFactory.getLogger(SpringBootJournalApplication.
	            class);

//	@Bean
//	InitializingBean saveData(JournalRepository repo) {
//		return () ->{
//			repo.save(new Journal("Get to know Spring Boot","Today I will learn Spring Boot","01/01/2016"));
//			repo.save(new Journal("Simple Spring Boot Project","I will do my first Spring Boot Project","01/02/2016"));
//			repo.save(new Journal("Spring Boot Reading","Read more about Spring Boot","02/01/2016"));
//			repo.save(new Journal("Spring Boot in the Cloud","Spring Boot using Cloud Foundry","03/01/2016"));
//		};
//	}
	
	@Bean
	CommandLineRunner start(JournalService service) {
		return args -> {
			log.info("@@ Inserting Data...");
			service.insertData();
			log.info("@@ findAll() calll..");
			service.findAll().forEach(entry -> log.info(entry.toString()));
		};
	}
	
	public static void main(String[] args) {
		//SpringApplication.run(SpringBootJournalApplication.class, args);
		SpringApplication app = new SpringApplication(SpringBootJournalApplication.class);
//		app.setBanner(new Banner() {
//
//			@Override
//			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//				out.print("\n\n\tThis is my own banner!\n\n".toUpperCase());
//			}
//		});
//		
		app.run(args);
	}
}
