package mum.edu.webstore.controllers;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mum.edu.webstore.model.Product;
import mum.edu.webstore.service.ProductService;

@Controller
@RequestMapping("/admin")
public class ProductController {
	private Logger log = Logger.getLogger(ProductController.class);
    @Autowired
	ProductService productService;
    @RequestMapping("/")
    public String redirectRoot() {
        return "redirect:/products";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("products", productService.getAll());
        return "admin/productList";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String addProduct(@ModelAttribute Product product) {
        return "admin/addProduct";
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String add(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/addProduct";
        } else {
            productService.add(product);
            return "redirect:/products";
        }
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.get(id));
        return "admin/productDetail";
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.POST)
    public String update(@Valid Product product, BindingResult result, @PathVariable int id) {
        if (result.hasErrors()) {
            return "admin/productDetail";
        } else {
            productService.update(id, product); // product.id already set by binding
            return "redirect:/products";
        }
    }

    @RequestMapping(value = "/products/delete", method = RequestMethod.POST)
    public String delete(int productId) {
        productService.delete(productId);
        return "redirect:/products";
    }

    @ExceptionHandler(value = NoSuchResourceException.class)
    public ModelAndView handle(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.getModel().put("e", e);
        mv.setViewName("noSuchResource");
        return mv;
    }
}
