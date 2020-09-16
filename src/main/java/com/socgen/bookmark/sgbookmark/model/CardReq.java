package com.socgen.bookmark.sgbookmark.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class CardReq {

	@NotNull
	private String originalUrl;
	
	@NotNull
	private String title;
	
	@NotNull
	private String description;
	
	private Date expiresAt;

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}
}
