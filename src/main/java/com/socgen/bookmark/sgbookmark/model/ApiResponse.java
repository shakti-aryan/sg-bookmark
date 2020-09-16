package com.socgen.bookmark.sgbookmark.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ApiResponse implements Serializable {

	private static final long serialVersionUID = 21379823811199L;
	
	private boolean ok;
	private Map<String,Object> data;
	
	public Map<String, Object> getData() {
		return data;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String key) {
		if(this.data == null)
			return null;
		return (T) data.get(key);
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
}
