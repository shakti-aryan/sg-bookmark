package com.socgen.bookmark.sgbookmark.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse implements Serializable {

	private static final long serialVersionUID = 21379823811199L;
	
	private boolean ok;
	private Map<String,Object> data;
	
	private ApiErrorModel error;
	
	public Map<String, Object> getData() {
		return data;
	}
	
	public ApiResponse() {
		
	}
	
	public ApiResponse(boolean ok, ErrorCode code, String message) {
		
		this.ok = ok;
		this.addError(new ApiErrorModel(code, message));
	}
	public void addError(String code, String message) {
		this.addError(new ApiErrorModel(code, message));
	}
	
	public void addError(ApiErrorModel errorModel) {
		this.error = errorModel;
	}

	public void add(String key,Object obj) {
		if(data == null) {
			data = new HashMap<>();
		}
		data.put(key,obj);
	}
	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public ApiErrorModel getError() {
		return error;
	}

	public void setError(ApiErrorModel error) {
		this.error = error;
	}
	
}
