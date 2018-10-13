package com.tracker.boot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author Bujair
 *
 */
@SpringBootApplication
@ComponentScan("com.tracker")
@EnableTransactionManagement
@EnableJpaAuditing
public class MyAPIApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MyAPIApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}
