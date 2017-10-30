package ecommerce.electronics.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ecommerce.electronics.model.SignupForm;
import ecommerce.electronics.model.User;
import ecommerce.electronics.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
    private UserRepository userRepository; 
	
	@RequestMapping(value="/login")
	public String Login (Model model) {
		return "login";
	}
	
	@RequestMapping(value="/signup")
	public String Signup (Model model) {
		model.addAttribute("signupForm", new SignupForm());
		return "signup";
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("signupForm") SignupForm signupForm, BindingResult bindingResult) {
    	if (!bindingResult.hasErrors()) { // validation errors
    		if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) { // check password match		
	    		String pwd = signupForm.getPassword();
		    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		    	String hashPwd = bc.encode(pwd);
		    	
		    	User newUser = new User();
		    	newUser.setUserName(signupForm.getUserName());
		    	newUser.setHashPassword(hashPwd);
		    	newUser.setEmail(signupForm.getEmail());
		    	newUser.setRole("USER");
		    	if (userRepository.findByUserName(signupForm.getUserName()) == null) { // Check if user exists
		    		userRepository.save(newUser);
		    	}
		    	else {
	    			bindingResult.rejectValue("userName", "err.userName", "Username already exists");    	
	    			return "signup";		    		
		    	}
    		}
    		else {
    			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");    	
    			return "signup";
    		}
    	}
    	else {
    		return "signup";
    	}
    	return "redirect:/login";    	
    }    
}
