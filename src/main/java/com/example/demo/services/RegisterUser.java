package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RegisteredUser;
import com.example.demo.repo.AuthicationRepo;


@Service
public class RegisterUser  implements AuthicationManger {

	@Autowired
	AuthicationRepo rr;
	
	@Override
	public void registerUser(RegisteredUser s) {
		// TODO Auto-generated method stub
		
		RegisteredUser existing = rr.findByEmail(s.getEmail());
	    if (existing != null) {
	        throw new RuntimeException("Email already registered");
	    }
	 
		rr.save(s);
		
		
	}

	@Override
	public RegisteredUser loginUser(String email, String password) {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
