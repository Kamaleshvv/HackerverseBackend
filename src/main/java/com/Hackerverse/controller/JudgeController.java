package com.Hackerverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hackerverse.bean.Idea;
import com.Hackerverse.bean.User;
import com.Hackerverse.service.IdeaService;
import com.Hackerverse.service.UserService;

@CrossOrigin(origins ="http://localhost:8080")
@RestController
@RequestMapping("judge")
public class JudgeController {
    @Autowired
	private UserService userService;
    @Autowired
	private IdeaService ideaService;
	private String currentEmail=null;
    
	@GetMapping("login")
    public String login(User u) {
    	if(userService.judgeLogin(u)) {
    		currentEmail=u.getEmail();
    		return "Login ASuccessful";
    	}
    	return "Invalid Credentials";
    }
    
	@GetMapping("dashboard")
    private List<Idea> getAcceptedIdeas() {
    	return ideaService.getApprovedIdea();
    }
}
