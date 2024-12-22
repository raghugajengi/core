package com.springboot.core;
// Java Program to illustrate Rest Controller REST API


// Importing required classes
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Annotation
@RestController
@RequestMapping(path = "/RestApi",
				produces = "application/json")
@CrossOrigin(origins = "*")

// Class
public class RestApiController {

	@GetMapping("/getData") 
    public UserData get()
	{
		UserData userData = new UserData();
		userData.setId("1");
		userData.setUserName("darshanGPawar@geek");
		userData.setData("Data send by Rest-API");

		return userData;
	}

    @GetMapping("/error") 
    public UserData getError()
	{
		UserData userData = new UserData();
		userData.setId("1");
		userData.setUserName("darshanGPawar@geek");
		userData.setData("Data send by Rest-API");

		return userData;
	}

	// Annotation
	@PostMapping
	public ResponseEntity<UserData>	post(@RequestBody UserData userData)
	{
		HttpHeaders headers = new HttpHeaders(); 
		return new ResponseEntity<>(userData, headers,
									HttpStatus.CREATED);
	}
}
