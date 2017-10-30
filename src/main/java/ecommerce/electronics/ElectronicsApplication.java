package ecommerce.electronics;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ecommerce.electronics.model.Product;
import ecommerce.electronics.model.User;
import ecommerce.electronics.repository.ProductRepository;
import ecommerce.electronics.repository.UserRepository;

@SpringBootApplication
public class ElectronicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectronicsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ProductRepository productRepository, UserRepository userRepository) {
		return (args) -> {
			
			userRepository.save(new User("user", "$2a$10$xTmLzWgMPyGO3TlNBYpOuu0dfDAlF5mXvQ5IJiF8utS/fEHKTgwna", "user@gmail.com", "0401234567", "Finland"));
			
			productRepository.save(new Product("Apple Iphone 8", "visual/iphonex.jpg", "Black", 1199.95));
			productRepository.save(new Product("Samsung Galaxy S8", "visual/galaxys8.jpg", "Midnight Black", 699.95));
			productRepository.save(new Product("Apple Iphone 7 Plus", "visual/iphone7plus.jpg", "Rose Gold", 799.95));
			productRepository.save(new Product("Huawei Mate 9 Pro", "visual/huaweimate9pro.jpg", "Silver", 699.95));
			productRepository.save(new Product("Oneplus 5", "visual/oneplus5.jpg", "Metal Black", 559.95));
			productRepository.save(new Product("Google Pixel XL", "visual/googlepixelxl.jpg", "Black", 599.95));
		};
	}
}
