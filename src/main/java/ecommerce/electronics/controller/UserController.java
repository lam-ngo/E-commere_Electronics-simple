package ecommerce.electronics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ecommerce.electronics.model.SignupForm;

@Controller
public class UserController {
	
	@RequestMapping(value="/login")
	public String Login (Model model) {
		return "login";
	}
	
	@RequestMapping(value="/signup")
	public String Signup (Model model) {
		model.addAttribute("signupForm", new SignupForm());
		return "signup";
	}
}
