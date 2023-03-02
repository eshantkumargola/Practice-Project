package com.expertorion.springboot.myfirstwebapp.hello.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class LoginController {
		
	private AuthenticationService authService;
		
	public LoginController(AuthenticationService authService) {
		super();
		this.authService = authService;
	}

	Logger logger=LoggerFactory.getLogger(LoginController.class);
	
//	@RequestMapping("login")	
//	public String gotoLoginPage(@RequestParam String name, ModelMap model )
//	{
//		model.put("username", name);
//		logger.info("      Req Param is {} ",name );
//		return "login";
//	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)	
	public String gotoLoginPage()
	{				
		return "login"; 
	}

	@RequestMapping(value="login", method=RequestMethod.POST)	
	public String gotoWelcomePage(
			@RequestParam String name, @RequestParam String pass, ModelMap model )
	{	
		
		if (authService.authenticate(name, pass)){
			model.put("username", name);
			//model.put("password", pass);
			return "welcome";
		}
		else
		{
			model.put("errorMessage"," Invalid Credentials. Please try again with valid creds! ");
			return "login";
		}
	}
	
	
}

