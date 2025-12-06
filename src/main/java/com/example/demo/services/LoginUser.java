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



//
//# ==============================================
//# SERVER PORT (Railway uses PORT env variable)
//# ==============================================
//server.port=${PORT:8080}
//
//
//# ==============================================
//# RAILWAY / CLOUD DATABASE CONFIG  (ACTIVE ON RAILWAY)
//# These values will come from Railway Environment Variables
//# ==============================================
//spring.datasource.url=${DB_URL}
//spring.datasource.username=${DB_USER}
//spring.datasource.password=${DB_PASSWORD}
//spring.datasource.driver-class-name=org.postgresql.Driver
//
//
//# ==============================================
//# LOCAL DEVELOPMENT DATABASE (USE WHEN TESTING LOCALLY)
//# Uncomment these 3 lines when running locally.
//# ==============================================
//# spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
//# spring.datasource.username=postgres
//# spring.datasource.password=Balaji@1337
//
//
//# ==============================================
//# JPA CONFIG
//
//
//
//# ==============================================
//spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
//spring.jpa.hibernate.ddl-auto=update
//spring.jpa.show-sql=true
//











//
//
//
//spring.application.name=AuthicationApi
//server.port=${PORT:8080}
//
//spring.datasource.url=jdbc:postgresql://db.lgthpynxbgdegqhjoyck.supabase.co:5432/postgres?sslmode=require
//
//spring.datasource.username=postgres
//spring.datasource.password=Balaji@1337
//spring.datasource.driver-class-name=org.postgresql.Driver
//
//spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
//
//spring.jpa.hibernate.ddl-auto=update
//spring.jpa.show-sql=true

