package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.neo4j.cypher.*;
//internal.compiler.v2_1.perty.printToString;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author miahmad
 *
 */
public class XSSServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {
    	
    		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("Beans.xml");
    		
    		InputDataDTO inputDataDTO =(InputDataDTO) applicationContext.getBean("inputdata");
    		inputDataDTO.setHtmlData(req.getParameter("htmlData"));
    		inputDataDTO.setJavascriptData(req.getParameter("javascriptData"));
    		inputDataDTO.setXmlData(req.getParameter("xmlData"));
    		
    		System.out.println("\n\nHTML Sanitized value: "+ inputDataDTO.getHtmlData());
    		System.out.println("\n\nJavaScript Sanitized value: "+ inputDataDTO.getJavascriptData());
    		System.out.println("\n\nXML Sanitized value: "+ inputDataDTO.getXmlData()+"\n");
    		
    		resp.setContentType("text/html");
    		PrintWriter writer = resp.getWriter();  		
    		writer.println (
                     "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
                          "http://www.w3.org/TR/html4/loose.dtd\">\n" +
                      "<html> \n" +
                        "<head> \n" +
                        "<style>"+
                      "table {"+
                          "border-collapse: collapse;"+
                      "}"+

                      "table, td, th {"+
                          "border: 1px solid black;"+
                      "}"+
                      "</style>"+
                          "<meta http-equiv=\"Content-Type\" content=\"text/html; " +
                            "charset=ISO-8859-1\"> \n" +
                          "<title> Enoded Input Data  </title> \n" +
                        "</head> \n" +
                        "<body bgcolor=\"#E6E6FA\"> <div align='left'> \n" +
                          "<style= \"font-size=\"12px\" color='black'\"" + "\">" +
                        "<form>"+
                        "<h1 style=\"color:blue\">Encoded Value of Parameters !!</h1>"+
                        "<table>"+
                          "<tr><td><b>HTML Encoded Values:</b></td><td>"+inputDataDTO.getHtmlData()+"</td></tr>"+
                          "<tr><td><b>JavaScript Encoded Values:</b></td><td>"+inputDataDTO.getJavascriptData()+"</td></tr>"+
                          "<tr><td><b>XML Encoded Values:</b></td><td>"+inputDataDTO.getXmlData()+"</td></tr>"+
                     "</table>"+
                            "</form>"+
                      "</html>" 
                    );  
    }
}