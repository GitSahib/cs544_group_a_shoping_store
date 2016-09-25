package mum.edu.webstore.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.edu.webstore.model.Cart;
import mum.edu.webstore.service.ProductService;

@Controller
@PreAuthorize("hasAuthority('CUSTOMER')")
public class CheckoutController {
	private Logger log = Logger.getLogger(CheckoutController.class);
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/single",method = RequestMethod.GET)
    String single(){
		log.info("Single view");
        return "single";
    }
	
	
    @RequestMapping(value="/other",method = RequestMethod.GET)
    String other(){
    	log.info("Other view");
        return "other";
    }
    
    
    @RequestMapping(value="/checkout",method = RequestMethod.GET)
    String checkout(Model model, HttpSession session){
    	
    	Cart cart = (Cart) session.getAttribute("cart");
    	if(cart == null){
    		cart = new Cart();
    		session.setAttribute("cart", cart);
    		
    		cart.addItem(productService.get(1), 1);
    		cart.addItem(productService.get(3), 1);
    	}
    	
    	model.addAttribute("cart", cart);
        return "checkout";
    }
}
