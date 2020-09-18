package com.socgen.bookmark.sgbookmark.service;

public interface UrlService {

	String convertToShortUrl(String originalUrl);
	
	String getGroupShortenUrl();
}
