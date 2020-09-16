package com.socgen.bookmark.sgbookmark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.socgen.bookmark.sgbookmark.model.ApiResponse;
import com.socgen.bookmark.sgbookmark.model.CardReq;
import com.socgen.bookmark.sgbookmark.service.CardService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/card")
public class CardController {
	
	@Autowired
	private CardService cardService;

	@PostMapping("/create")
	@ResponseBody
	public ApiResponse createCard(@RequestBody CardReq cardDetail) {
		
		ApiResponse response = new ApiResponse();
		response.add("card", cardService.createCard(cardDetail));
		response.setOk(true);
		return response;
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ApiResponse fetchById(@PathVariable Integer id) {
		
		ApiResponse response = new ApiResponse();
		response.add("card", cardService.fetchCardById(id));
		response.setOk(true);
		return response;
	}
	
	@GetMapping("/url")
	@ResponseBody
	public ApiResponse fetchByTinyUrl(@RequestParam(required=true, value="shortUrl") String shortUrl) {
		
		ApiResponse response = new ApiResponse();
		response.add("card", cardService.fetchCardByTinyUrl(shortUrl));
		response.setOk(true);
		return response;
	}
	
}
