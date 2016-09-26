package mum.edu.webstore.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.edu.webstore.model.Cart;
import mum.edu.webstore.model.Product;
import mum.edu.webstore.service.ProductService;

@Controller
public class ShippingCartController {
	
	/*
	@Autowired
	ProductService productService;
	
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String detail(Model model, HttpSession session) {
    	
    	Cart cart = (Cart) session.getAttribute("cart");
    	if(cart == null){
    		cart = new Cart();
    		session.setAttribute("cart", cart);
    		
    		cart.addItem(productService.get(1), 1);
    	}
    	
    	model.addAttribute("cart", cart);
          return "checkout";
    }
    */

}
