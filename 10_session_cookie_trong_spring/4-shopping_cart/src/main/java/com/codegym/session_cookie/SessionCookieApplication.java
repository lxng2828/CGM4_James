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
	public CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				long productCount = productRepository.count();

				if (productCount == 0) {
					Product product1 = new Product(null, "iPhone 15 Pro", 1199.00, 10);
					Product product2 = new Product(null, "Samsung Galaxy S24 Ultra", 1299.00, 15);
					Product product3 = new Product(null, "Macbook Pro M3", 2499.00, 5);
					Product product4 = new Product(null, "Dell XPS 15", 1899.00, 8);

					productRepository.save(product1);
					productRepository.save(product2);
					productRepository.save(product3);
					productRepository.save(product4);

					System.out.println("Sample products have been created successfully.");
				} else {
					System.out.println("Products already exist in the database. Skipping sample data creation.");
				}
			}
		};
	}

}