package com.expertorion.springboot.myfirstwebapp.hello.login;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String username, String password)
	{
		return  (username.equals("expert") && password.equals("dummy"));		
	}
}
