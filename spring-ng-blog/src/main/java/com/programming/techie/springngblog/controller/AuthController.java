package com.programming.techie.springngblog.controller;

import com.programming.techie.springngblog.dto.LoginRequest;
import com.programming.techie.springngblog.dto.RegisterRequest;
import com.programming.techie.springngblog.model.User;
import com.programming.techie.springngblog.repository.UserRepository;
import com.programming.techie.springngblog.service.AuthService;
import com.programming.techie.springngblog.service.AuthenticationResponse;
import com.programming.techie.springngblog.model.Response;


import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
    
//    @PostMapping("/login")
//    	public ResponseEntity<?> loginUser(@RequestBody User userData){
//    		User user = userRepo.findByUserName(userData.getUserName());
//    		if(user.getPassword().equals(userData.getPassword())) {
//    			return ResponseEntity.ok(user);
//    		}
//    		return (ResponseEntity<?>) ResponseEntity.badRequest();
//    	}
    
    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestParam("user_name") String user_name,
                                           @RequestParam("currentPassword") String currentPassword,
                                           @RequestParam("newPassword") String newPassword) {
        // Retrieve the user from the database
          User user = userRepo.findByUserName(user_name);
        if (user == null) {
        	return Response.status(HttpStatus.NOT_FOUND);
        }

        // Validate the current password
        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
        	return Response.status(HttpStatus.BAD_REQUEST);
        }

        // Update the password in the database
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepo.save(user);
        return Response.status(HttpStatus.OK);
    
    }
    
    @PutMapping("/forgot-password")
    public ResponseEntity<?> ForgotPassword(@RequestParam("email") String email,
                                           @RequestParam("NewPassword") String NewPassword){
    	User user = userRepo.findByEmail(email);
    	if (user == null) {
    		return Response.status(HttpStatus.NOT_FOUND);
        }
    	if ( passwordEncoder.matches(NewPassword, user.getPassword())) {
    		return Response.status(HttpStatus.BAD_REQUEST);
    	}
    	user.setPassword(passwordEncoder.encode(NewPassword));
    	userRepo.save(user);
    	return Response.status(HttpStatus.OK);
    }
}
    
    
    

