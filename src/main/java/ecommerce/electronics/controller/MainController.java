package ecommerce.electronics.controller;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
import ecommerce.electronics.model.CartItem;
import ecommerce.electronics.repository.ProductRepository;
import ecommerce.electronics.service.ShoppingCartService;


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
	public @ResponseBody Map<Long, Integer> AddToCart (@PathVariable("productId") Long productId, HttpServletRequest request, Model model) {
		
		//Create a hashmap to hold key: productId and value: totalQuantity of that product
		Map<Long, Integer> cartTotal = new HashMap<Long, Integer>();
		
		HttpSession session = request.getSession();
		
		cartTotal = (Map<Long, Integer>)session.getAttribute("cartTotal");
		
		Iterator iterator = cartTotal.entrySet().iterator();
        while (iterator.hasNext()) {
        	Map.Entry existedProduct = (Map.Entry) iterator.next();
        	
        	//check if cart already had that productId
        	if(productId == existedProduct.getKey()) {
        		cartTotal.put(productId, cartTotal.get(productId)+1);
        	}else {
        		cartTotal.put(productId, 1);
        	}
        } 
		
		return cartTotal;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/cart/total")
	public @ResponseBody Map<Long, Integer> cartTotal (HttpServletRequest request, Model model) {
		Map<Long, Integer> cartTotal = new HashMap<Long, Integer>();
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("cartTotal") == null) {
			session.setAttribute("cartTotal", cartTotal);
		}else {
			cartTotal = (Map<Long, Integer>)session.getAttribute("cartTotal");
		}
		
		return cartTotal;
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	@RequestMapping(value="/cart")
	public String shoppingCart (HttpServletRequest request, Model model) {
		List<CartItem> cart = new ArrayList<>();
		
		HttpSession session = request.getSession();
		
		Map<Long, Integer> cartTotal = new HashMap<Long, Integer>();
		cartTotal = (Map<Long, Integer>)session.getAttribute("cartTotal");
		Iterator iterator = cartTotal.entrySet().iterator();
        while (iterator.hasNext()) {
        	Map.Entry existedProduct = (Map.Entry) iterator.next();
        	
        	Product product = productRepository.findOne((Long) existedProduct.getKey());
        	
        	int totalQuantity = (int)existedProduct.getValue();
        	Double totalPrice = totalQuantity * product.getPrice();
        	
        	CartItem cartItem = new CartItem(product.getProductId(), product.getName(), product.getColor(), totalQuantity, totalPrice);
        	
        	cart.add(cartItem);
        } 
		
		model.addAttribute("cart",cart);
		return "cart";
	}
}
