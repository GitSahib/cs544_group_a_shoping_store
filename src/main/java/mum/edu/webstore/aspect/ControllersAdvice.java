package mum.edu.webstore.aspect;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import mum.edu.webstore.WebStoreAppCtxHolder;
@DependsOn("webStoreAppCtxHolder")
@Component
@Aspect
public class ControllersAdvice extends Advise{
	ControllersAdvice() {
		super(ControllersAdvice.class);
	}
	MessageSource messageSource = WebStoreAppCtxHolder.getApplicationContext().getBean(ResourceBundleMessageSource.class);	
   	@Before("execution(* mum.edu.webstore.controller.*.*(..))")
	public void controllerActionBefore(JoinPoint joinPoint) 
	{
		setLanguage();
		logRequestBefore(joinPoint);
	}
   	@After("execution(* mum.edu.webstore.controller.*.*(..))")
	public void controllerActionAfer(JoinPoint joinPoint) 
	{
		logRequestAfter(joinPoint);
	}
   	private void logRequestBefore(JoinPoint jp) {
		// TODO Auto-generated method stub
		logger.info("A request to:"+jp.getTarget()+" Method:"+jp.getSignature() +" is about to process");
	}
   	private void logRequestAfter(JoinPoint jp) {
		// TODO Auto-generated method stub
		logger.info("A request to:"+jp.getTarget()+" Method:"+jp.getSignature() +" procesed");
	}
	private void setLanguage()
   	{
   		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		Cookie[] cookies= request.getCookies();
		if(cookies == null){return;}
		for(Cookie cookie:cookies)
		{
			if (cookie.getName().equals("lang")) {
				((ResourceBundleMessageSource)messageSource).setBasename("validation-" + cookie.getValue());
				logger.info("Client Lang is:" + cookie.getValue());
			}
		}	
   	}
}
