package ecommerce.electronics;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import ecommerce.electronics.model.User;
import ecommerce.electronics.repository.UserRepository;

/*
 * Testing that User instance can be created
 * Testing that user has been added to UserRepository
 * 
 * @author: Lam Ngo
 * 
 * */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void CreateUserTest () {
		User user = new User("testinguser", "$2a$10$xTmLzWgMPyGO3TlNBYpOuu0dfDAlF5mXvQ5IJiF8utS/fEHKTgwna", "testinguser@gmail.com", "USER");
		userRepository.save(user);
		assertThat(user.getUserId()).isNotNull();
		assertThat(user.getUserName()).isEqualTo("testinguser");
	} 
	
	@Test
	public void RepositoryTest () {
		User testingUser = userRepository.findByUserName("user");
		
		assertThat(testingUser).isNotNull();
		assertThat(testingUser.getUserName()).isEqualTo("user");
	} 
}
