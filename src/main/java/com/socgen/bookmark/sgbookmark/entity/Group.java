package com.socgen.bookmark.sgbookmark.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;

/**
 * The persistent class for the "group_details" database table.
 * 
 */
@Entity
@Table(name = "group_details", schema = "tinyurl")
@NamedQuery(name = "Group.findAll", query = "SELECT g FROM Group g")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "GROUP_DETAILS_ID_GENERATOR", sequenceName = "tinyurl.group_details_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GROUP_DETAILS_ID_GENERATOR")
	@Column(name = "\"id\"")
	private int id;

	@Column(name = "\"created_by\"")
	private int createdBy;

	@Column(name = "\"created_date\"")
	private Timestamp createdDate;

	@Column(name = "\"description\"")
	private String description;

	@Column(name = "\"group_image\"")
	private byte[] groupImage;

	@Column(name = "\"isactive\"")
	private boolean isactive;

	@Column(name = "\"name\"")
	private String name;
	
	@Column(name="group_url")
	private String groupUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getGroupImage() {
		return groupImage;
	}

	public void setGroupImage(byte[] groupImage) {
		this.groupImage = groupImage;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroupUrl() {
		return groupUrl;
	}

	public void setGroupUrl(String groupUrl) {
		this.groupUrl = groupUrl;
	}

}