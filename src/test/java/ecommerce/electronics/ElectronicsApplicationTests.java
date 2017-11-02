package ecommerce.electronics;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ecommerce.electronics.controller.ProductController;
import ecommerce.electronics.controller.UserController;

/*
 * Testing that the context is creating ProductController and UserController
 * 
 * @author Lam Ngo
 * 
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElectronicsApplicationTests {

	@Autowired
	private ProductController productController;
	
	@Autowired
	private UserController userController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(productController).isNotNull();
		assertThat(userController).isNotNull();
	}

}
