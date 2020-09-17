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

import com.socgen.bookmark.sgbookmark.service.CardService;
import com.socgen.bookmark.sgbookmark.service.UrlService;

@RestController
@CrossOrigin
@RequestMapping("/r")
public class RedirectController {
	
	@Autowired
	private CardService cardService;
	
	@GetMapping(value = "/{shortUrl}")
    @Cacheable(value = "urls", key = "#shortUrl", sync = true)
    public ResponseEntity<Void> getAndRedirect(@PathVariable String shortUrl) {
        String url = cardService.fetchOrignialUrl(shortUrl);
        System.out.println("original url is "+url);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url))
                .build();
    }
}
