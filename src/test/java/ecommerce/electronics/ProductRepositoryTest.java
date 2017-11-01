package ecommerce.electronics;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import ecommerce.electronics.model.Product;
import ecommerce.electronics.repository.ProductRepository;

/*
 * Testing that Product instance can be created
 * Testing that product has been added to ProductRepository
 * 
 * @author: Lam Ngo
 * 
 * */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void CreateProductTest () {
		Product product = new Product("Nokia 8", "Nokia 8 picture", "Black", 599.95);
		productRepository.save(product);
		assertThat(product.getProductId()).isNotNull();
		assertThat(product.getName()).isEqualTo("Nokia 8");
	} 
	
	@Test
	public void RepositoryTest () {
		List<Product> productTest = productRepository.findByName("Apple Iphone 8");
		
		assertThat(productTest.size()).isNotNull();
		assertThat(productTest.get(0).getName()).isEqualTo("Apple Iphone 8");
	} 
	
}
