package com.codegym.session_cookie;

import com.codegym.session_cookie.model.Product;
import com.codegym.session_cookie.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SessionCookieApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionCookieApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			if (productRepository.count() == 0) {
				Product p1 = new Product(null, "iPhone 15 Pro", 1199.00, 10);
				Product p2 = new Product(null, "Samsung Galaxy S24 Ultra", 1299.00, 15);
				Product p3 = new Product(null, "Macbook Pro M3", 2499.00, 5);
				Product p4 = new Product(null, "Dell XPS 15", 1899.00, 8);
				productRepository.save(p1);
				productRepository.save(p2);
				productRepository.save(p3);
				productRepository.save(p4);
				System.out.println("Sample products created!");
			}
		};
	}
}