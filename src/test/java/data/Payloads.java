package data;

import java.io.IOException;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Payloads {
	public static RequestSpecification req;
	public static String AddPost(String title, String body, String userId) {
		String payload="{\r\n" + 
				"\"title\":\""+title+"\",\r\n"+
				"\"body\":\""+body+"\",\r\n" + 
				"\"userId\":\""+userId+"\"\r\n" + 
				"}";
		
		return payload;
	}
	
	public static String AddPostWithTitleOnly(String title) {
		String payload="{\r\n" + 
				"\"title\":\""+title+"\",\r\n"+ 
				"}";
		
		return payload;
		
	}
	
	public static RequestSpecification requestSpecification() throws IOException
	{
		 req=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com")
		.build();
		
		return req;
	}
	
	
	

}
