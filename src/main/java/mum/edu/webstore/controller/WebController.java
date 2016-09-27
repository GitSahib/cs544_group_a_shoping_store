package mum.edu.webstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import mum.edu.webstore.WebStoreAppCtxHolder;
import mum.edu.webstore.service.UserService;

public abstract class WebController {
	
	WebController()
	{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		UserService userService = WebStoreAppCtxHolder.getApplicationContext().getBean(UserService.class);
	}
}
