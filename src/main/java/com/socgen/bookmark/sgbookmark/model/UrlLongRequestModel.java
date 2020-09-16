package com.socgen.bookmark.sgbookmark.model;

import java.util.Date;


public class UrlLongRequestModel {

    private String longUrl;

    public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public Date getExpiresDate() {
		return expiresDate;
	}

	public void setExpiresDate(Date expiresDate) {
		this.expiresDate = expiresDate;
	}

	private Date expiresDate;
	
}
