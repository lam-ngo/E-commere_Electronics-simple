package ecommerce.electronics.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ecommerce.electronics.model.Product;

import java.util.HashMap;


public class ShoppingCartService {

	public Map<Long, Integer> cartTotal (HttpServletRequest request){
		Map<Long, Integer> cartTotal = new HashMap<Long, Integer>();
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("cartTotal") == null) {
			session.setAttribute("cartTotal", cartTotal);
		}else {
			cartTotal = (Map<Long, Integer>)session.getAttribute("cartTotal");
		}
		
		return cartTotal;
	}
}
