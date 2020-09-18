package com.socgen.bookmark.sgbookmark.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socgen.bookmark.sgbookmark.exception.ExceptionMapper;
import com.socgen.bookmark.sgbookmark.service.CardService;

@RestController
@CrossOrigin
@RequestMapping("/r")
public class RedirectController extends ExceptionMapper{
	
	@Autowired
	private CardService cardService;
	
	@GetMapping(value = "/{shortUrlCode}")
    @Cacheable(value = "urls", key = "#shortUrl", sync = true)
    public ResponseEntity<Void> getAndRedirect(@PathVariable String shortUrlCode) {
        String url = cardService.fetchOrignialUrl(shortUrlCode);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url))
                .build();
    }
}
