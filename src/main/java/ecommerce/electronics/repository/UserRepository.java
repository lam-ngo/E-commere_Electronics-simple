package ecommerce.electronics.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import ecommerce.electronics.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findByUserName(String userName);
}
