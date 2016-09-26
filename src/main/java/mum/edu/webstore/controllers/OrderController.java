package mum.edu.webstore.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.edu.webstore.model.Cart;
import mum.edu.webstore.model.CartItem;
import mum.edu.webstore.model.Customer;
import mum.edu.webstore.model.Order;
import mum.edu.webstore.model.OrderItem;
import mum.edu.webstore.model.User;
import mum.edu.webstore.service.AddressService;
import mum.edu.webstore.service.OrderService;
import mum.edu.webstore.service.SecurityService;
import mum.edu.webstore.service.UserService;

@Controller
public class OrderController {
	
	private Logger log = Logger.getLogger(OrderController.class);
	
	@Autowired
	SecurityService securityService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrderService orderService;

	@Autowired
	AddressService addressService;
	
	
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String orderIndex(Model model, HttpSession session) {
    	
    	Cart cart = (Cart) session.getAttribute("cart");
    	if(cart == null || cart.getIsEmpty()) {
    		return "index";
    	}
    	
        model.addAttribute("order", new Order());
        model.addAttribute("countries", addressService.getAllCountries());
        return "order";
    }
    
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String orderPost(@Valid Order order, Model model, HttpSession session, BindingResult result) {
    	
        if (result.hasErrors()) {
            return "order";
        }
    	
    	Cart cart = (Cart) session.getAttribute("cart");
    	if(cart == null || cart.getIsEmpty()) {
    		return "index";
    	}
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	org.springframework.security.core.userdetails.User spuser = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
    	User user = userService.findByUsername(spuser.getUsername());
    	Customer customer = user.getCustomer();
    	
    	
    	order.setCustomer(customer);
    	order.setTotal(cart.getTotalPrice());
    	
    	for(CartItem ci : cart.getItems()) {
    		OrderItem oi = new OrderItem();
    		
    		oi.setOrder(order);
    		oi.setProduct(ci.getProduct());
    		oi.setQuantity(ci.getQuantity());
    		
    		order.getOrderItems().add(oi);
    	}
    	
    	
    	orderService.save(order);
    	session.setAttribute("cart", null);		//Clear Cart
    	
    	
    	//model.addAttribute("orders", orderService.getAll());
    	
        return "redirect:/orderList";
    }
    
    @RequestMapping(value = "/orderList", method = RequestMethod.GET)
    public String orderListGet(Model model, HttpSession session) {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	org.springframework.security.core.userdetails.User spuser = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
    	User user = userService.findByUsername(spuser.getUsername());
    	Customer customer = user.getCustomer();
    	
    	model.addAttribute("orders", orderService.getAllByCustomer(customer.getId()));
    	
        return "orderList";
    }
    
    @RequestMapping(value = "/orderDetail/{id}", method = RequestMethod.GET)
    public String orderDetailGet(@PathVariable long id, Model model, HttpSession session) {
    	model.addAttribute("order", orderService.get(id));
    	
        return "orderDetail";
    }
}
