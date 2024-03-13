package com.Hackerverse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Hackerverse.bean.Idea;
import com.Hackerverse.bean.Team;
import com.Hackerverse.bean.TeamCreationInput;
import com.Hackerverse.bean.User;
import com.Hackerverse.repo.IdeaRepository;
import com.Hackerverse.repo.TeamRepository;
import com.Hackerverse.repo.UserRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Service
public class UserService {
    @Autowired
	private UserRepository repo;
    @Autowired
	private IdeaRepository ideaRepo;
    @Autowired
    private TeamRepository teamRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public String createUser(User u) {
    	String email=u.getEmail();
    	User check=repo.findByEmail(email);
    	if(check!=null) {
    		if(check.getRole().equals("Leader"))
    			return "Participant "+u.getEmail()+" exists as a Team Leader. Login with above mail";
    		if(check.getRole().equals("Member"))
    			return "Participant "+u.getEmail()+" exists as a Team Member. Login with above mail";
    		return "Evaluator already exists. Login with above mail";
    	}
    	
    	u.setPassword(passwordEncoder.encode(u.getPassword()));
    	repo.save(u);
    	if(u.getRole().equals("Leader"))
    		return "Participant created. Login with same mail";
    	return "Evaluator created";
    }
    
    public String removeEvaluator(User u) {
    	
    	User check=repo.findByEmail(u.getEmail());
    	if(check==null)
    		return "Evaluator does not exist";
    	if(check.getRole().equals("Leader") || check.getRole().equals("Member"))
    		return "Participants cannot be removed";
    	
    	repo.delete(check);
    	return "Evaluator removed";
    }
    
    public boolean login(User u, HttpSession session) {
    	
    	//User userCheck=repo.findByEmailAndPassword(u.getEmail(), passwordEncoder.encode(u.getPassword()));
    	User userCheck=repo.findByEmail(u.getEmail());
    	if(userCheck!=null && passwordEncoder.matches(u.getPassword(), userCheck.getPassword()) && (userCheck.getRole().equals("Leader") || userCheck.getRole().equals("Member"))) {
    		session.setAttribute("currentUser", userCheck);
    		session.setMaxInactiveInterval(3600);
    		return true;
    	}
    	return false;
    }
    
    public boolean panelistLogin(User u, HttpSession session) {
    	User userCheck=repo.findByEmailAndPassword(u.getEmail(), u.getPassword());
    	if(userCheck!=null && userCheck.getRole().equals("Panelist")) {
    		session.setAttribute("currentPanelist", userCheck);
    		session.setMaxInactiveInterval(3600);
    		return true;
    	}
    	return false;
    }
    
    public boolean judgeLogin(User u) {
    	User userCheck=repo.findByEmailAndPassword(u.getEmail(), u.getPassword());
    	if(userCheck!=null && userCheck.getRole().equals("Judge"))
    		return true;
    	return false;
    }
    
    public boolean adminLogin(User u) {
    	User userCheck=repo.findByEmailAndPassword(u.getEmail(), u.getPassword());
    	if(userCheck!=null && userCheck.getRole().equals("Admin"))
    		return true;
    	return false;
    }
    
    public User getUser(HttpSession session) {
    	return (User)session.getAttribute("currentUser");
    }
}
