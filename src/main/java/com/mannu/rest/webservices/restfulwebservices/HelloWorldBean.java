package com.mannu.rest.webservices.restfulwebservices;

public class HelloWorldBean  {
	
	private String message;

	public HelloWorldBean(String string) {
		this.message=message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
}