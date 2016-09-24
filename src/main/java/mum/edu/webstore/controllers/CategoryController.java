package mum.edu.webstore.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {
	private Logger log = Logger.getLogger(CategoryController.class);
    @RequestMapping(value="/womens", method = RequestMethod.GET)
    String womens()
    {
    	log.info("call to cat controller");
        return "womens";
    }
    @RequestMapping(value="/mens", method = RequestMethod.GET)
    String mens()
    {
    	log.info("call to cat controller");
        return "mens";
    }
}
