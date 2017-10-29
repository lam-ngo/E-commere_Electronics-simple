package ecommerce.electronics.controller;

import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ecommerce.electronics.model.Product;
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
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/addToCart/{productId}")
	public @ResponseBody List<Product> AddToCart (@PathVariable("productId") Long productId, HttpServletRequest request, Model model) {
		
		List<Product> cart = new ArrayList<>();
		
		HttpSession session = request.getSession();
		
		Product product = productRepository.findOne(productId);
		
		cart = (List<Product>)session.getAttribute("cart");
		cart.add(product);
		
		return cart;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/cart/total")
	public @ResponseBody int cartTotal (HttpServletRequest request, Model model) {
		List<Product> cart = new ArrayList<>();
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("cart") == null) {
			session.setAttribute("cart", cart);
		}else {
			cart = (List<Product>)session.getAttribute("cart");
		}
		
		return cart.size();
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	@RequestMapping(value="/cart")
	public String shoppingCart (HttpServletRequest request, Model model) {
		List<Product> cart = new ArrayList<>();
		
		HttpSession session = request.getSession();
		
		cart = (List<Product>) session.getAttribute("cart");
		
		model.addAttribute("products",cart);
		
		return "cart";
	}
}
