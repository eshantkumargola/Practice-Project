package com.expertorion.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/say-hello")
	@ResponseBody
	public String sayHello()
	{
		return "Hello! What are you going to learn today ? "; 
	}

	@RequestMapping("/say-hello-html")
	@ResponseBody
	public StringBuffer sayHelloHtml()
	{
		StringBuffer sb=new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> Welcome Page Updated!! </title>");		
		sb.append("<head>");		
		sb.append("<body>");
		sb.append("My First Html Webpage with a new body. ");
		sb.append("</body>");
		sb.append("</html>");
					
		return sb; 
	}
	
	// say-hello-jsp ==> HelloWorldController -->sayHelloJsp() method ==> sayHello.jsp
	@RequestMapping("say-hello-jsp")	
	public String sayHelloJsp()
	{
		return "sayHello";
	}
	
}

