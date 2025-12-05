package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RegisteredUser;
import com.example.demo.repo.AuthicationRepo;



@Service
public class LoginUser implements AuthicationManger{

	@Override
	public void registerUser(RegisteredUser s) {
		// TODO Auto-generated method stub
		
	}
	
//	@Autowired
//	AuthicationRepo rr;
//	
//	public void loginUser(String email, String password) {
//
//	    RegisteredUser user = rr.findByEmail(email);
//
//	    if (user == null) {
//	        throw new RuntimeException("User not found");
//	    }
//
//	    if (!user.getPassword().equals(password)) {
//	        throw new RuntimeException("Invalid password");
//	    }
//
//	    // If both checks pass → login success
//	}

	
	
	@Autowired
	AuthicationRepo rr;

	public RegisteredUser loginUser(String email, String password) {

	    RegisteredUser user = rr.findByEmail(email);

	    if (user == null) {
	        throw new RuntimeException("User not found");
	    }

	    if (!user.getPassword().equals(password)) {
	        throw new RuntimeException("Invalid password");
	    }

	    return user;   // ⬅️ IMPORTANT so controller can send data
	}


}
