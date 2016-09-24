package mum.edu.webstore.controllers;

import org.apache.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@PreAuthorize("hasAuthority('CUSTOMER')")
public class CheckoutController {
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
    String checkout(){
    	log.info("Checkout view");
        return "checkout";
    }
}
