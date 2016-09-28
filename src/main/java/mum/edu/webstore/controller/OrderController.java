package mum.edu.webstore.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
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
import mum.edu.webstore.model.PaymentType;
import mum.edu.webstore.model.User;
import mum.edu.webstore.service.AddressService;
import mum.edu.webstore.service.CartItemService;
import mum.edu.webstore.service.CustomerService;
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
	
	@Autowired
	CustomerService customerService;
	
 	@Autowired
 	private CartItemService cartItemService;
	
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String orderIndex(Model model, HttpSession session, HttpServletRequest request) {
    	
        String name = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "";
		Customer customer = customerService.getByEmail(name.toString());
		Cart cart = customer.getCart();
		if(cart.getCartItems().size() <= 0)
		{
			return "redirect:/checkout";
		}
    	
    	//Cart cart = (Cart) session.getAttribute("cart");
    	//if(cart == null || cart.getIsEmpty()) {
    	//	return "index";
    	//}
    	
        model.addAttribute("order", new Order());
        model.addAttribute("countries", addressService.getAllCountries());
        model.addAttribute("paymentTypes", PaymentType.values());
        return "orders/order";
    }
    
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String orderPost(@Valid Order order, BindingResult result, Model model, HttpSession session, HttpServletRequest request) {
    	
        if (result.hasErrors()) {
        	log.error("Order validation failed");
            return "checkout";
        }
    	
        String name = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "";
		Customer customer = customerService.getByEmail(name.toString());
		Cart cart = customer.getCart();
		if(cart.getCartItems().size() <= 0)
		{
			return "redirect:/checkout";
		}
	
    	
    	order.setCustomer(customer);
    	order.setTotal(cart.getGrandTotal());
    	Set<OrderItem> orderItems = new HashSet<OrderItem>();
    	order.setOrderItems(orderItems);
    	for(CartItem ci : cart.getCartItems()) {
    		OrderItem oi = new OrderItem();
    		
    		oi.setOrder(order);
    		oi.setProduct(ci.getProduct());
    		oi.setQuantity(ci.getQuantity());
    		
    		order.getOrderItems().add(oi);
    	}
    	
    	
    	orderService.save(order);


    	cartItemService.removeAllCartItems(cart);
    	
        return "redirect:/orderDetail/"+order.getId();
    }
    
    @RequestMapping(value = "/orderList", method = RequestMethod.GET)
    public String orderListGet(Model model, HttpSession session) {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User user = userService.findByUsername(auth.getName());
    	
    	Customer customer = user.getCustomer();
    	
    	model.addAttribute("orders", orderService.getAllByCustomer(customer.getId()));
    	
        return "orders/orderList";
    }
    
    @RequestMapping(value = "/orderDetail/{id}", method = RequestMethod.GET)
    public String orderDetailGet(@PathVariable long id, Model model, HttpSession session) {
    	model.addAttribute("order", orderService.get(id));
    	
        return "orders/orderDetail";
    }
}
