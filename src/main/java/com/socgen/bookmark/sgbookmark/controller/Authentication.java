package com.socgen.bookmark.sgbookmark.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.socgen.bookmark.sgbookmark.model.ApiResponse;
import com.socgen.bookmark.sgbookmark.service.AuthService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
@Slf4j
public class Authentication {
	
	@Autowired
	private AuthService authService;

	/*
	 * @PostMapping(value="/auth")
	 * 
	 * @ResponseBody public ApiResponse processUserLogin() {
	 * 
	 * ApiResponse response = new ApiResponse(); response.setOk(true); return
	 * response; }
	 */
	
	@RequestMapping(value = "/user")
	public Principal user(Principal principal) {
      return principal;
	}
}
