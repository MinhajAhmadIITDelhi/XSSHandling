package sanitization;

import java.lang.reflect.Method;
import org.aspectj.lang.ProceedingJoinPoint;
import org.owasp.esapi.ESAPI;

/**
 * 
 * @author miahmad
 *
 */
public class XSSHandlerUtil {
	
	/**
	 * HTML Sanitizer
	 * @param method
	 * @param args
	 * @param joinPoint
	 * @throws Throwable
	 */
	public static void htmlEncoding(Method method, Object[] args, ProceedingJoinPoint joinPoint) throws Throwable {

		for (int i =0 ; i < args.length; i++){		
			if(args[i] instanceof String)
			{			
				args[i] = ESAPI.encoder().encodeForHTML((String) args[i]);			
				
			}
		}
		joinPoint.proceed(args);
	}

	/**
	 * XML Sanitizer
	 * @param method
	 * @param args
	 * @param joinPoint
	 * @throws Throwable
	 */
	public static void xmlEncoding(Method method, Object[] args, ProceedingJoinPoint joinPoint) throws Throwable {

		for (int i =0 ; i < args.length; i++){		
			if(args[i] instanceof String)
			{			
				args[i] = ESAPI.encoder().encodeForXML((String) args[i]);

			}
		}
		joinPoint.proceed(args);
	}

	/**
	 * JavaScript Sanitizer
	 * @param method
	 * @param args
	 * @param joinPoint
	 * @throws Throwable
	 */
	public static void javaScriptEncoding(Method method, Object[] args, ProceedingJoinPoint joinPoint) throws Throwable {

		for (int i =0 ; i < args.length; i++){		
			if(args[i] instanceof String)
			{			
				args[i] = ESAPI.encoder().encodeForJavaScript((String) args[i]);
				
			}
		}
		joinPoint.proceed(args);
	}

	/**
	 * CSS Sanitizer
	 * @param method
	 * @param args
	 * @param joinPoint
	 * @throws Throwable
	 */
	public static void cssEncoding(Method method, Object[] args, ProceedingJoinPoint joinPoint) throws Throwable {

		for (int i =0 ; i < args.length; i++){		
			if(args[i] instanceof String)
			{			
				args[i] = ESAPI.encoder().encodeForCSS((String) args[i]);

			}
		}
		joinPoint.proceed(args);
	}

	
}
