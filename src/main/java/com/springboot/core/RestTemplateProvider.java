package com.springboot.core;
// Java Program to Implementation of RestTemplate
//C. File: RestTemplateProvider.java (RestTemplate implementation)

//GET – Consumes REST API’s GET mapping response and returns domain object.
//POST – Consumes REST API’s POST mapping response and return ResponseEntity object.
// Importing required classes
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

// Class
public class RestTemplateProvider {

	// Creating an instance of RestTemplate class
	RestTemplate rest = new RestTemplate();

	// Method
	public UserData getUserData()
	{
		return rest.getForObject(
			"http://localhost:8080/RestApi/getData",
			UserData.class);
	}

	// Method
	public ResponseEntity<UserData> post(UserData user)
	{
		return rest.postForEntity(
			"http://localhost:8080/RestApi", user,
			UserData.class, "");
	}
}
