package ecommerce.electronics;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ecommerce.electronics.model.Product;
import ecommerce.electronics.repository.ProductRepository;

@SpringBootApplication
public class ElectronicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectronicsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ProductRepository productRepository) {
		return (args) -> {
			productRepository.save(new Product("Apple Iphone 8", "http://drop.ndtv.com/TECH/product_database/images/913201720152AM_635_iphone_x.jpeg", "Black", 1199.95));
			productRepository.save(new Product("Samsung Galaxy S8", "https://cf1.s3.souqcdn.com/item/2017/03/29/22/34/46/67/item_XL_22344667_30264426.jpg", "Midnight Black", 699.95));
			productRepository.save(new Product("Apple Iphone 7 Plus", "https://www.kickmobiles.com/content/images/thumbs/0007094_apple-iphone-7-plus-32gb-gold.jpeg", "Rose Gold", 799.95));
			productRepository.save(new Product("Huawei Mate 9 Pro", "http://img.c.huaweistatic.com/content/dam/huawei-cbg-site/en/mkt/pdp/phones/mate9pro/img/home/pic_connectivity_01.png", "Silver", 699.95));
			productRepository.save(new Product("Oneplus 5", "https://image4.geekbuying.com/ggo_pic/2017-06-21/2017062101437331bka1gmu.jpg", "Metal Black", 559.95));
			productRepository.save(new Product("Google Pixel XL", "https://www.techspot.com/images/products/smartphones/org/2016-10-18-product-3.jpg", "Black", 599.95));
		};
	}
}
