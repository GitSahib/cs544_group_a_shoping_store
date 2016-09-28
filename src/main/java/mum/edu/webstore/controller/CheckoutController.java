package mum.edu.webstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.edu.webstore.model.Cart;
import mum.edu.webstore.model.Customer;
import mum.edu.webstore.model.Order;
import mum.edu.webstore.service.CartService;
import mum.edu.webstore.service.CustomerService;

@Controller
public class CheckoutController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CartService cartService;
	
	private Logger log = Logger.getLogger(CheckoutController.class);
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
    String checkout(HttpServletRequest request,HttpSession session, Model model){
    	String name = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "";
		Customer customer = customerService.getByEmail(name.toString());
		if(customer == null)
		{
			return "redirect:/customerinfo";
		}
		Cart cart = customer.getCart();
		session.setAttribute("cartItems", cart.getCartItems().size());
		request.setAttribute("cart", cart);
		session.setAttribute("cartsession",cart);
		model.addAttribute("order",new Order());
        return "checkout";
    }
}
