package mum.edu.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.edu.webstore.service.ProductService;

@Controller
public class IndexController {
	
	@Autowired
	ProductService productService;
	
	
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String home(Model model) {
    	model.addAttribute("products", productService.getAll());
          return "index";
    }
    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public String about(Model model) {
          return "about";
    }
    @RequestMapping(value = {"/contact", "/contact.html","contact.jsp"}, method = RequestMethod.GET)
    public String contact(Model model) {
          return "contact";
    }
}
