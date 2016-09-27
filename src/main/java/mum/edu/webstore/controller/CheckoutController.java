package mum.edu.webstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.edu.webstore.model.Cart;
import mum.edu.webstore.model.Customer;
import mum.edu.webstore.service.CartService;
import mum.edu.webstore.service.CustomerService;

@Controller
public class CheckoutController {
	@Autowired
	private CustomerService customerService;
	
	
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
    String checkout(HttpServletRequest request,HttpSession session){
    	
        return "checkout";
    }
}
