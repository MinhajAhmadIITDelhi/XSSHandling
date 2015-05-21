package demo;

import annotation.HTMLSanitization;
import annotation.JavaScriptSanitization;

public class Student {


	private Integer age;
	private String name;
	private String department;


	public String getDepartment() {
		System.out.println("Get Department : " + department );
		return department;
	}

	@JavaScriptSanitization
	public void setDepartment(String department) {
		this.department = department;
	}
	@JavaScriptSanitization
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Integer getAge() {
		return age;
	}
	@HTMLSanitization
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void printThrowException(){
		throw new IllegalArgumentException();
	}
}
