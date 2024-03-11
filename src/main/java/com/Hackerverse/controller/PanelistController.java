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
import com.Hackerverse.bean.User;
import com.Hackerverse.service.IdeaService;
import com.Hackerverse.service.UserService;

import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("panelist")
public class PanelistController {
    @Autowired
	private IdeaService ideaService;
    @Autowired
    private UserService userService;
    
    @PostMapping("login")
    public String login(@RequestBody User u, HttpSession session) {
      if(userService.panelistLogin(u,session)) {
    		return "Login Successful";
    	}
      return "Invalid Credentials";
    }
    
    @GetMapping("dashboard")
    public List<Idea> getIdeas(HttpSession session) {
    	return ideaService.getAllIdea(session);
    }
    
    @PutMapping("acceptIdea")
    public String acceptIdea(@RequestBody Idea i, HttpSession session) {
    	return ideaService.acceptIdea(i, session);
    }
    
    @PutMapping("rejectIdea")
    public String rejectidea(@RequestBody Idea i, HttpSession session) {
    	return ideaService.rejectIdea(i, session);
    }
}
