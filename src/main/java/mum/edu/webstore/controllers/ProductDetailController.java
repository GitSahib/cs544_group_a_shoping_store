package mum.edu.webstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.edu.webstore.model.Product;
import mum.edu.webstore.service.ProductService;

@Controller
public class ProductDetailController {

	@Autowired
	ProductService productService;
	
	
    @RequestMapping(value = "/productDetails/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable long id, Model model) {
    	Product product = productService.get(id);
    	model.addAttribute("product", product);
          return "laptop";
    }
}
