package de.viadee.sbpm.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@EnableBatchProcessing
public class SpringBatchPerformanceMonitoringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchPerformanceMonitoringDemoApplication.class, args);
	}
}
