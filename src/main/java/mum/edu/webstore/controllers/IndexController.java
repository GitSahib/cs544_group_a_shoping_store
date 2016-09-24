package mum.edu.webstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String home(Model model) {
          return "index";
    }
    @RequestMapping(value = {"/contact", "/contact.html","contact.jsp"}, method = RequestMethod.GET)
    public String contact(Model model) {
          return "contact";
    }
}
