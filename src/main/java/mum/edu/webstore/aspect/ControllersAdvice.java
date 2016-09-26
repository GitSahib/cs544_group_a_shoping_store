package mum.edu.webstore.aspect;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import mum.edu.webstore.SpringApplicationContextHolder;
@DependsOn("springApplicationContextHolder")
@Component
@Aspect
public class ControllersAdvice {
	private Logger logger = Logger.getLogger(ControllersAdvice.class);
	MessageSource messageSource = SpringApplicationContextHolder.getApplicationContext().getBean(ResourceBundleMessageSource.class);	
   	@Before("execution(* mum.edu.webstore.controller.*.*(..))")
	public void controllerAction(JoinPoint joinPoint) 
	{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		Cookie[] cookies= request.getCookies();
		for(Cookie cookie:cookies)
		{
			logger.info(messageSource);
			if (cookie.getName().equals("lang")) {
				((ResourceBundleMessageSource)messageSource).setBasename("validation-" + cookie.getValue());
				logger.info("Cookie Name:" + cookie.getName());
			}
		}		
	}
}
