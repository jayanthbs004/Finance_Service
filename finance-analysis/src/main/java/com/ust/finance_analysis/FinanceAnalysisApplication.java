package com.ust.finance_analysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FinanceAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceAnalysisApplication.class, args);
	}

}
