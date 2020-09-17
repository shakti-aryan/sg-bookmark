package com.socgen.bookmark.sgbookmark.service.impl;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import com.socgen.bookmark.sgbookmark.constant.AppConstant;
import com.socgen.bookmark.sgbookmark.service.UrlService;
import com.socgen.bookmark.sgbookmark.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Service
@Slf4j
public class UrlServiceImpl implements UrlService {
	
	private static final Logger log = Logger.getLogger(UrlServiceImpl.class);

	private char myChars[];

	private Random myRand; // Random object used to generate random integers

	UrlServiceImpl() {
		myRand = new Random();
		myChars = new char[62];
		for (int i = 0; i < 62; i++) {
			int j = 0;
			if (i < 10) {
				j = i + 48;
			} else if (i > 9 && i <= 35) {
				j = i + 55;
			} else {
				j = i + 61;
			}
			myChars[i] = (char) j;
		}
	}

	@Override
	public String convertToShortUrl(String longURL) {
		
		if(ObjUtil.isBlank(longURL))
			throw new IllegalArgumentException();
		return AppConstant.redirectDomain + getKey(longURL);
	}

	public static String sanitizeURL(String url) {

		if (url.charAt(url.length() - 1) == '/')
			url = url.substring(0, url.length() - 1);
		return url;
	}

	private String getKey(String longURL) {
		log.info("shortning url ==> " + longURL);
		return generateRandomKey();
	}

	private String generateRandomKey() {
		String key = "";
		for (int i = 0; i <= AppConstant.tinyUrlCodeLength; i++) {
			key += myChars[myRand.nextInt(62)];
		}
		return key;
	}
}
