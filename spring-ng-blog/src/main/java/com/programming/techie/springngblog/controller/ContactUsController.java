package com.programming.techie.springngblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.programming.techie.springngblog.model.ContactUs;

import com.programming.techie.springngblog.service.ContactUsService;


@RestController
@CrossOrigin("*")
public class ContactUsController {
	@Autowired
	  private ContactUsService contactusservice;
//	@Autowired
//	private ProfilePageService service;
	  
	  @PostMapping({"/contactUs"})
	  public ContactUs addContactUs(@RequestBody ContactUs contactus) {
		  return contactusservice.addContactUs(contactus);
	  }
	  
//	  @PutMapping("/Profile")
//	  public ResponseEntity<ProfilePage> update(@RequestBody ProfilePage profilePage){
//		  return ResponseEntity.ok(this.service.Update(profilePage));
//	  }
	  
//	  @GetMapping("/Profile/{id}")
        
}
