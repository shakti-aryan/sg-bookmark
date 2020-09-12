package com.socgen.bookmark.sgbookmark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.socgen.bookmark.sgbookmark.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
//	@Value("${authserver.clientid}")
//	private String clientId;
//	
//	@Value("${authserver.clientsecret}")
//	private String clientSecret;
//	
//	@Value("${authserver.authurl}")
//	private String authUrl;
//	
//	@Value("${authserver.tokenurl}")
//	private String tokenUrl;
//	
//	@Value("${authserver.userInfoUrl}")
//	private String userInfoUrl;
	
	@Override
	public void processOAuthLogin() {
		
		
	}

}
