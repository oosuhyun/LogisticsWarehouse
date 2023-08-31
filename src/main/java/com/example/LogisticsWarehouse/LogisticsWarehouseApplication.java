package com.example.LogisticsWarehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LogisticsWarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticsWarehouseApplication.class, args);
	}

}
