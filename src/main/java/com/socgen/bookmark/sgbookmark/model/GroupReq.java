package com.socgen.bookmark.sgbookmark.model;

import java.util.List;

import lombok.Data;
import lombok.NonNull;

@Data
public class GroupReq {
	
	@NonNull
	private String name;
	
	@NonNull
	private String description;
	
	@NonNull
	private List<Integer> cardIdList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Integer> getCardIdList() {
		return cardIdList;
	}

	public void setCardIdList(List<Integer> cardIdList) {
		this.cardIdList = cardIdList;
	}
}
