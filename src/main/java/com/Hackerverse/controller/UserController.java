package com.Hackerverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hackerverse.bean.Idea;
import com.Hackerverse.bean.Team;
import com.Hackerverse.bean.TeamCreationInput;
import com.Hackerverse.bean.User;
import com.Hackerverse.service.UserService;

import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
	private UserService userService;
	
    @PostMapping("register")
    public String createUser(@RequestBody User u) {
    	u.setRole("Leader");
		return userService.createUser(u);
	}
    
    @PostMapping("login")
    public String login(@RequestBody User u, HttpSession session) {
    	
    	if(userService.login(u,session))
    		return "Login successful";
    	return "Invalid login Credentials";
    }
    
    @PostMapping("createTeam")
    public String createTeam(@RequestBody TeamCreationInput input, HttpSession session) {
        return userService.createTeam(input, session);
    }
    
    @PostMapping("submitIdea")
    public String submitIdea(@RequestBody Idea i, HttpSession session) {
    	return userService.submitIdea(session, i);
    }
    
    @PutMapping("editIdea")
    public String editIdea(@RequestBody Idea i, HttpSession session) {
    	return userService.editIdea(session, i);
    }
    
    @GetMapping("dashboard")
    public User getUser(HttpSession session) {
    	return userService.getUser(session);
    }
    
    @GetMapping("logout")
    public String endSession(HttpSession session) {
    	if (session != null) {
            session.invalidate(); // Invalidate the session
        }

        return "Logged Out Successful";
    }
}
