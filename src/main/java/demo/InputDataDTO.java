package demo;

import annotation.CSSSanitization;
import annotation.HTMLSanitization;
import annotation.JavaScriptSanitization;
import annotation.XMLSanitization;

public class InputDataDTO {

	private String htmlData;
	private String javascriptData;
	private String xmlData;
	private String sqlData;
	private String CSSData;
	private String URLData;
	
	
	
	public String getHtmlData() {
		return htmlData;
	}
	
	@HTMLSanitization
	public void setHtmlData(String htmlData) {
		this.htmlData = htmlData;
	}
	public String getJavascriptData() {
		return javascriptData;
	}
	@JavaScriptSanitization
	public void setJavascriptData(String javascriptData) {
		this.javascriptData = javascriptData;
	}
	public String getXmlData() {
		return xmlData;
	}
	@XMLSanitization
	public void setXmlData(String xmlData) {
		this.xmlData = xmlData;
	}
	public String getSqlData() {
		return sqlData;
	}
	public void setSqlData(String sqlData) {
		this.sqlData = sqlData;
	}
	public String getCSSData() {
		return CSSData;
	}
	@CSSSanitization
	public void setCSSData(String cSSData) {
		CSSData = cSSData;
	}
	public String getURLData() {
		return URLData;
	}
	public void setURLData(String uRLData) {
		URLData = uRLData;
	}
	
	
	
}
