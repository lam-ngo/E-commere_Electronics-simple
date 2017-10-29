package ecommerce.electronics.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import ecommerce.electronics.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findByName(String name);
}
