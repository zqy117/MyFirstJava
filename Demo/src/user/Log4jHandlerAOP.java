package user;

//import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;

@Aspect
public class Log4jHandlerAOP {

//	Logger logger;
	/**
	 * Following is the definition for a pointcut to select all the methods
	 * available. So advice will be called for all the methods.
	 */
	@Pointcut("execution(* user.WelcomeUserAction.findSalseOrder(..))")
	private void selectAll() {
	}

	/**
	 * This is the method which I would like to execute before a selected method
	 * execution.
	 */
//	@Before("selectAll()")
//	public void beforeAdvice() {
//
//		System.out.println("Going to setup student profile.");
//	}

	/**
	 * This is the method which I would like to execute after a selected method
	 * execution.
	 */
	@After("selectAll()")
	public void afterAdvice() {
//		logger = Logger.getLogger(Log4jHandlerAOP.class);
//		logger.info("记录日志成功");
		System.out.println("记录日志成功！");
	}

	/**
	 * This is the method which I would like to execute when any method returns.
	 */
	@AfterReturning(pointcut = "selectAll()", returning = "retVal")
	public void afterReturningAdvice(Object retVal) {
		System.out.println("Returning:" + retVal.toString());
	}
}
