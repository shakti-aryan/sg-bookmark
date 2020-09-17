package com.socgen.bookmark.sgbookmark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socgen.bookmark.sgbookmark.model.ApiResponse;
import com.socgen.bookmark.sgbookmark.service.UrlService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class UrlShortnerController {

	@Autowired
	private UrlService urlService;
	
	@ApiOperation(value = "generate shorten url", notes = "This srevice is to test shorten url service, redirection to actual url will not work for the urls generated using this controller")
	@PostMapping("/shorten-url")
	public ApiResponse shortenUrl(@RequestBody String longUrl) {
		
		ApiResponse response = new ApiResponse();
		response.add("url", urlService.convertToShortUrl(longUrl));
		response.setOk(true);
		return response;
	}
}
