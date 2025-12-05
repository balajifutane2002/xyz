package com.example.demo.services;

import com.example.demo.entity.RegisteredUser;

public interface AuthicationManger {
	
	
	public void registerUser(RegisteredUser s);
	public RegisteredUser loginUser(String email, String password);

}
