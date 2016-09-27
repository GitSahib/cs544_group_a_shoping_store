package mum.edu.webstore.controller;


import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import mum.edu.webstore.model.Customer;
import mum.edu.webstore.model.Role;
import mum.edu.webstore.model.User;
import mum.edu.webstore.service.CustomerService;
import mum.edu.webstore.service.RoleService;
import mum.edu.webstore.service.SecurityService;
import mum.edu.webstore.service.UserService;
import mum.edu.webstore.validator.CustomerValidator;
import mum.edu.webstore.validator.UserValidator;
@SessionAttributes("user")
@Controller
public class UserController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	private Logger log = Logger.getLogger(UserController.class);
	@Autowired
	private SecurityService securityService;
	@Autowired
	private CustomerValidator customerValidator;
	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("customerForm", new Customer());

		return "newcustomer";
	}
	
	@RequestMapping(value = "/customerinfo", method = RequestMethod.GET)
	public String customerinfo(Model model,HttpServletRequest request) {
		Customer customer = new Customer();
		String email = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "";
		customer.setEmail(email);
		model.addAttribute("customerForm", customer);
		
		return "customerinfo";
	}
	@RequestMapping(value = "/customerinfo", method = RequestMethod.POST)
	public String customerinfo(@ModelAttribute("customerForm") Customer customerForm, BindingResult bindingResult, Model model) {
		customerValidator.validate(customerForm, bindingResult);
		// model.addAttribute(bindingResult.getFieldError());
		
		log.info(customerForm);
		if (bindingResult.hasErrors()) {
			log.error("Customer Form Invalid");
			return "customerinfo";
		}
		User user = userService.findByUsername(customerForm.getEmail());
		customerForm.setUser(user);
		customerService.save(customerForm);
		securityService.autologin(customerForm.getEmail(), customerForm.getPassword());
		return "redirect:/index";
	}
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("customerForm") Customer customerForm, BindingResult bindingResult, Model model) {
		customerValidator.validate(customerForm, bindingResult);
		// model.addAttribute(bindingResult.getFieldError());
		
		log.info(customerForm);
		if (bindingResult.hasErrors()) {
			log.error("Customer Form Invalid");
			return "newcustomer";
		}
		User user = customerService.getUser(customerForm);
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			log.error("User Form Invalid");
			return "newcustomer";
		}
		userService.save(user);
		customerForm.setUser(user);
		customerService.save(customerForm);
		securityService.autologin(customerForm.getEmail(), customerForm.getPassword());
		return "redirect:/index";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    session.invalidate();
	    return "redirect:/index";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String accessdenied() {
	    return "accessdenied";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		
		return "login";
	}
	
	
	@RequestMapping(value = "/reguser", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("userForm", new User());

		return "register";
	}
	@RequestMapping(value = "/reguser", method = RequestMethod.POST)
	public String register(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		
		
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			log.error("User Form Invalid");
			return "register";
		}
		Role role = roleService.findRoleByName("Customer");
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		userForm.setRoles(roles);
		userService.save(userForm);
		securityService.autologin(userForm.getUsername(), userForm.getPassword());
		return "redirect:/index";
	}
}
