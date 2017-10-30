package ecommerce.electronics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ecommerce.electronics.model.User;
import ecommerce.electronics.repository.UserRepository;

@Service
public class UserDetailService {
	private final UserRepository userRepository;
	
	@Autowired
	public UserDetailService (UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException { 
		User currentUser = userRepository.findByUserName(userName);
		
		UserDetails user = new org.springframework.security.core.userdetails.User(userName, currentUser.getHashPassword(),AuthorityUtils.createAuthorityList("User"));
		
		return user;
	}
}
