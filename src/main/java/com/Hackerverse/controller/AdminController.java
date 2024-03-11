package com.Hackerverse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hackerverse.bean.User;
import com.Hackerverse.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("admin")
public class AdminController {
    
	@Autowired
	private UserService userService;
	
	@GetMapping("login")
	public String login(@RequestBody User u) {
		if(userService.adminLogin(u))
			return "Login successful";
		return "Invalid login Credentials";
	}
	
	@PostMapping("addEvaluator")
	public String addEvaluator(@RequestBody User u) {
		return userService.createUser(u);
	}
	
	@DeleteMapping("removeEvaluator")
	public String removeEvaluator(@RequestBody User u) {
	    return userService.removeEvaluator(u);
	}
}
