package com.socgen.bookmark.sgbookmark.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthenticationController {
	
	
	@PostMapping(value = "/user")
	public Principal user(Principal principal) {
      return principal;
	}
	
	
	@GetMapping(value = "/getCurrentContextUser")
	public String userInfo() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getDetails());
		return auth.getName();
	}
	
}
