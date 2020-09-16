package com.socgen.bookmark.sgbookmark.service.impl;


import org.springframework.stereotype.Service;

import com.socgen.bookmark.sgbookmark.service.UrlService;

import java.util.HashMap;
import java.util.Random;

import javax.persistence.EntityNotFoundException;

/*
 * URL Shortener
 */
@Service
public class UrlServiceImpl implements UrlService {
	
	private HashMap<String, String> keyMap = new HashMap<>(); // key-url map
	private HashMap<String, String> valueMap = new HashMap<>();// url-key map to quickly check
	
	private String domain = "http://localhost:8080/r/";
	private char myChars[]; 
	
	private Random myRand; // Random object used to generate random integers
	
	private int keyLength = 6; // the key length in URL defaults to 6

	
	  // Default Constructor URLShortener() {
	UrlServiceImpl(){
	  myRand = new Random();
	  myChars = new char[62]; 
	  for (int i = 0;i < 62; i++) { 
		  int j = 0; 
		  if (i < 10) { 
			  j = i + 48; 
		  } else if (i > 9 && i <= 35) { j = i + 55; } else { j = i + 61; } myChars[i] = (char) j; }
	  }
	 
	@Override
	public String convertToShortUrl(String longURL) {
		String shortURL = "";
		longURL = sanitizeURL(longURL);
		if (valueMap.containsKey(longURL)) {
			shortURL = domain + valueMap.get(longURL);
		} else {
			shortURL = domain + getKey(longURL);
		}
		
		return shortURL;
	}

	// expandURL
	// public method which returns back the original URL given the shortened url
	@Override
	public String getOriginalUrl(String shortUrl) {
		String longURL = "";
		shortUrl = sanitizeURL(shortUrl);
		String key = shortUrl.substring(shortUrl.lastIndexOf("/")+1);
//		String key = shortUrl.substring(domain.length() + 1);
		longURL = keyMap.get(key);
		
		if(longURL == null) {
			throw new EntityNotFoundException("Not Available");
		}
		return longURL;
	}

	String sanitizeURL(String url) {
//		if (url.contains("http://"))
//			url = url.substring(7);
//		else if (url.contains("https://"))
//			url = url.substring(8);

		if (url.charAt(url.length() - 1) == '/')
			url = url.substring(0, url.length() - 1);
		return url;
	}

	/*
	 * Get Key method
	 */
	private String getKey(String longURL) {
		String key;
		key = generateKey();
		keyMap.put(key, longURL);
		valueMap.put(longURL, key);
		return key;
	}

	private String generateKey() {
		String key = "";
		boolean flag = true;
		while (flag) {
			key = "";
			for (int i = 0; i <= keyLength; i++) {
				key += myChars[myRand.nextInt(62)];
			}
			if (!keyMap.containsKey(key)) {
				flag = false;
			}
		}
		return key;
	}
}

