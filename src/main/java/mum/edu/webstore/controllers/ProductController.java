package mum.edu.webstore.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mum.edu.webstore.model.Category;
import mum.edu.webstore.model.Product;
import mum.edu.webstore.model.Stock;
import mum.edu.webstore.service.CategoryService;
import mum.edu.webstore.service.ProductService;

@Controller
@RequestMapping("/admin")
public class ProductController {
	private Logger log = Logger.getLogger(ProductController.class);
	
	@Autowired
	private ServletContext servletContext;
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}


	@Autowired
	ProductService productService;
    @Autowired
	CategoryService categoryService;
    
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
    public String add(@Valid Product product, final @RequestPart(value = "file", required = false) MultipartFile file, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/addProduct";
        } else {
        	
        	Stock stock = new Stock();
        	stock.setProduct(product);
        	stock.setQuantity(product.getStockNumber());
        	product.setStock(stock);
        	
        	if(file.getSize() > 0) {
        		product.setImageUrl(saveImage(file));
        	}
        	
            productService.add(product);
            return "redirect:/admin/products";
        }
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.get(id));
        return "admin/editProduct";
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.POST)
    public String update(@Valid Product product, BindingResult result, @PathVariable int id) {
        if (result.hasErrors()) {
            return "admin/editProduct";
        } else {
            productService.update(id, product); // product.id already set by binding
            return "redirect:/admin/products";
        }
    }
    
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id) {
    	//Product product = productService.get(id);
    	//product.getStock().setProduct(null);
    	//stockService.delete(product.getStock());
        productService.delete(id);
        return "redirect:/admin/products";
    }
    

    @ExceptionHandler(value = NoSuchResourceException.class)
    public ModelAndView handle(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.getModel().put("e", e);
        mv.setViewName("noSuchResource");
        return mv;
    }
    
    @ModelAttribute("productCategories")
    public Collection<Category> productCategories() {
		return categoryService.getAll();
    }
    
    
    private String saveImage(MultipartFile image)  {
    	UUID idOne = UUID.randomUUID();
    	String fileName = idOne.toString();

    	String fullPathName = servletContext.getRealPath("/images") + "/" + fileName;
	    File file = new File(fullPathName);
	    		
	    FileOutputStream stream;
		try {
			stream = new FileOutputStream(file);
		    stream.write(image.getBytes());
		    stream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "/images/" + fileName;
	}
}
