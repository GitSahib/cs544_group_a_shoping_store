package mum.edu.webstore.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ModelsAdvice extends Advise {
	public ModelsAdvice() {
		super(ModelsAdvice.class);
	}
	@Before("execution(* mum.edu.webstore.service.*.save(..))")
	public void modelActionBefore(JoinPoint joinPoint) 
	{
		logActionBefore(joinPoint);
	}
	@After("execution(* mum.edu.webstore.service.*.save(..))")
	public void modelActionAfter(JoinPoint joinPoint) 
	{
		logActionAfter(joinPoint);
	}
   	private void logActionBefore(JoinPoint jp) {
		// TODO Auto-generated method stub
		logger.info("A request to:"+jp.getTarget()+" Method:"+jp.getSignature() +" is about to process");
		if(jp.getArgs().length > 1)
			logger.info("With Argument:" + jp.getArgs()[1]);
		else if(jp.getArgs().length > 0)
			logger.info("With Argument:" +jp.getArgs()[0]);
	}
   	private void logActionAfter(JoinPoint jp)
   	{
   		
   		logger.info("A request to:"+jp.getTarget()+" Method:"+jp.getSignature() +" processed");
   		if(jp.getArgs().length > 1)
			logger.info("With Argument:" + jp.getArgs()[1]);
		else if(jp.getArgs().length > 0)
			logger.info("With Argument:" +jp.getArgs()[0]);
   	}
	
}
