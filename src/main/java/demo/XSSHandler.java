package demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import sanitization.XSSHandlerUtil;
import annotation.CSSSanitization;
import annotation.HTMLSanitization;
import annotation.JavaScriptSanitization;
import annotation.XMLSanitization;


/**
 * 
 * @author miahmad
 *
 */
@Aspect
public class XSSHandler {

	@Pointcut("execution(* demo.*.set*(..))")
	private void selectAll(){}


	@Around("selectAll()")
	public void beforeAdvice(ProceedingJoinPoint joinPoint) throws Throwable{

		Signature signature = joinPoint.getSignature();
		MethodSignature mSignature = (MethodSignature) signature;
		Object[] args = joinPoint.getArgs();

		Method method=mSignature.getMethod();
		Annotation[] annotation=method.getAnnotations();

		for (int i=0;i<annotation.length;i++)
		{
			if(annotation[i] instanceof CSSSanitization){
				XSSHandlerUtil.cssEncoding(mSignature.getMethod(), args, joinPoint);
			}
			else if (annotation[i] instanceof HTMLSanitization) {
				XSSHandlerUtil.htmlEncoding(mSignature.getMethod(), args, joinPoint);
			}
			else if (annotation[i] instanceof XMLSanitization) {
				XSSHandlerUtil.xmlEncoding(mSignature.getMethod(), args, joinPoint);
			}
			else if (annotation[i] instanceof JavaScriptSanitization) {
				XSSHandlerUtil.javaScriptEncoding(mSignature.getMethod(), args, joinPoint);
			}

		}


	}
}
