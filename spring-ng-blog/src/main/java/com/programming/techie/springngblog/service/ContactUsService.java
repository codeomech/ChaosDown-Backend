package com.programming.techie.springngblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programming.techie.springngblog.model.ContactUs;
import com.programming.techie.springngblog.repository.ContactUsRepository;

@Service
public class ContactUsService {
 @Autowired
 private ContactUsRepository contactusrepo;
  
 public ContactUs addContactUs(ContactUs contactUs) {
	 return contactusrepo.save(contactUs);
 }
 
}
