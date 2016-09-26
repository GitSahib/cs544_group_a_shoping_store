package mum.edu.webstore.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LocaleController {
	@Autowired
	MessageSource messageSource;
	@RequestMapping(value = "/locale")
	public String changeLocale(@RequestParam(value = "lang") String lang,
			@RequestHeader(value = "referer", required = false) final String referer,
			HttpServletResponse response) {
		// create cookie and set it in response
		Cookie cookie = new Cookie("lang", lang.toString());
		response.addCookie(cookie);
		// render hello.jsp page
		return "redirect:"+referer;
	}

}