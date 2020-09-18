package com.socgen.bookmark.sgbookmark.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupDetail {

	private Integer id;
	
	private String name,
	
	description,
	
	group_url;
	
	private List<CardDetail> associatedCards;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getGroup_url() {
		return group_url;
	}

	public void setGroup_url(String group_url) {
		this.group_url = group_url;
	}

	public List<CardDetail> getAssociatedCards() {
		return associatedCards;
	}

	public void setAssociatedCards(List<CardDetail> associatedCards) {
		this.associatedCards = associatedCards;
	}

}
