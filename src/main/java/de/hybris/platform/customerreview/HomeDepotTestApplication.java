package de.hybris.platform.customerreview;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class HomeDepotTestApplication {

	public static void main(String[] args) {
		
		new SpringApplicationBuilder() //
		.sources(HomeDepotTestApplication.class)//
		.run(args);
		//SpringApplication.run(HomeDepotTestApplication.class, args);
	}
}
