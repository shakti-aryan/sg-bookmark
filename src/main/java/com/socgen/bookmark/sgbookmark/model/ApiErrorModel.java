package com.socgen.bookmark.sgbookmark.model;

public class ApiErrorModel {

	private String code;
	private String message;
	
	
	public ApiErrorModel(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public ApiErrorModel(ErrorCode errorCode, String message) {
		
		this.code = errorCode != null ? errorCode.toString() : null;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
