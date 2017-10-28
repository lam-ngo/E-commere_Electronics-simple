package ecommerce.electronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ecommerce.electronics.repository.ProductRepository;

@Controller
public class MainController {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value="/")
	public String Homepage (Model model) {
		model.addAttribute("products", productRepository.findAll());
		return "index";
	}
}
