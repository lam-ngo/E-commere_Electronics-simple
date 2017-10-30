package ecommerce.electronics.repository;

import org.springframework.data.repository.CrudRepository;

import ecommerce.electronics.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUserName(String userName);

}
