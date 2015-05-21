package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		

		@SuppressWarnings("resource")
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("Beans.xml");	
		Student student =(Student) applicationContext.getBean("student");
		InputDataDTO inputDataDTO =(InputDataDTO) applicationContext.getBean("inputdata");
		System.out.println("Encode DTO HTML: "+ inputDataDTO.getHtmlData());
		//student.setName("<html>document.write('hi')</html>");
		inputDataDTO.setHtmlData("<html>document.write('hi')</html>");
		System.out.println("Encode DTO HTML: "+ inputDataDTO.getHtmlData());
		System.out.println("Encoded Value: "+student.getName());
		
		
		
		
		

	}

}
