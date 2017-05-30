package de.hybris.platform.customerreview;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class CustomerReviewTestApplication {

	public static void main(String[] args) {
		
		new SpringApplicationBuilder() //
		.sources(CustomerReviewTestApplication.class)//
		.run(args);
	}
}
