package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RegisteredUser;
import com.example.demo.request.LoginRequest;
import com.example.demo.responce.LoginResponse;
import com.example.demo.responce.registerUserResponce;
import com.example.demo.services.LoginUser;
import com.example.demo.services.RegisterUser;
import com.example.demo.token.JwtUtil;

@RestController
public class AuthController {
	
	
	@Autowired
	RegisterUser sr;
	@Autowired
	LoginUser ss;

	@PostMapping("/register")
	public registerUserResponce registerUser(@RequestBody RegisteredUser user) {

//	    try {
//	        sr.registerUser(user);
//	        return "Registered successfully";
//	    }
//	    catch (RuntimeException ex) {
//	        return ex.getMessage();   // return message: "Email already registered"
//	    }
	
	
	

        try {
            sr.registerUser(user);
            return new registerUserResponce("success", "Registered successfully");

        } catch (RuntimeException ex) {
            return new registerUserResponce("error", ex.getMessage());
        }}
	

	
//	@PostMapping("/login")
//	public registerUserResponce loginUser(@RequestBody LoginRequest loginRequest) {
//
//	    try {
//	        ss.loginUser(
//	                loginRequest.getEmail(),
//	                loginRequest.getPassword()
//	        );
//
//	        return new registerUserResponce("success", "Login successful");
//	    }
//	    catch (RuntimeException ex) {
//	        return new registerUserResponce("error", ex.getMessage());
//	    }
//	}
	
	
	
	 	@Autowired
	    private JwtUtil jwtUtil;

	    @PostMapping("/login")
	    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest) {

	        try {
	            // 1) validate email + password
	            RegisteredUser user = ss.loginUser(
	                    loginRequest.getEmail(),
	                    loginRequest.getPassword()
	            );

	            // 2) generate JWT token using user's email
	            String token = jwtUtil.generateToken(user.getEmail());

	            // 3) build and return full response
	            return new LoginResponse(
	                    "success",
	                    "Login successful",
	                    user.getId(),
	                    user.getName(),
	                    user.getEmail(),
	                    token
	            );

	        } catch (RuntimeException ex) {

	            return new LoginResponse(
	                    "error",
	                    ex.getMessage(),
	                    null, null, null, null
	            );
	        }
	    }

	
	
}
