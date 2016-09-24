package mum.edu.webstore.controllers;

import mum.edu.webstore.model.Customer;
import mum.edu.webstore.model.Role;
import mum.edu.webstore.model.User;
import mum.edu.webstore.service.CustomerService;
import mum.edu.webstore.service.SecurityService;
import mum.edu.webstore.service.UserService;
import mum.edu.webstore.validator.CustomerValidator;
import mum.edu.webstore.validator.UserValidator;

import java.util.HashSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    private Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    @Autowired
    private CustomerValidator customerValidator;
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Customer());

        return "register";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Customer userForm, BindingResult bindingResult, Model model) {
        customerValidator.validate(userForm, bindingResult);
        // model.addAttribute(bindingResult.getFieldError());
        log.info(userForm);
        if (bindingResult.hasErrors()) {
        	log.info(userForm);
            return "register";
        }
        User user = new User();
        Role role = userService.findRoleByName("Customer");
        HashSet<Role> roles = new HashSet<Role>();
        roles.add(role);
        user.setRoles(roles);
        user.setUsername(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setPasswordConfirm(userForm.getPassword());
        //userValidator.validate(user, bindingResult);
        // model.addAttribute(bindingResult.getFieldError());
        log.info(user);
        if (bindingResult.hasErrors()) {
        	log.info(user);
            return "register";
        }
        userService.save(user);
        userForm.setUser(user);
        customerService.save(userForm);
        securityService.autologin(userForm.getEmail(), userForm.getPassword());

        return "redirect:/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
}
