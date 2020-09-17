package com.socgen.bookmark.sgbookmark.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="card_details", schema = "tinyurl")
@Data
@NamedQuery(name = "Card.findAll", query = "SELECT c from Card c")
public class Card implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="CARD_DETAILS_ID_GENERATOR", sequenceName = "tinyurl.card_details_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARD_DETAILS_ID_GENERATOR")
	private Integer id;
	
	@NotNull
	@Column(name="title")
	private String title;
	
	@NotNull
	@Column(name="description")
	private String description;
	
	@NotNull
	@Column(name="long_url")
	private String longUrl;
	
	@NotNull
	@Column(name="tiny_url")
	private String tinyUrl;
	
	@Column(name="expiry_date")
	private Timestamp expiryDate;
	
	@Column(name="created_date")
	private Timestamp createdDate;
	
	@ManyToOne
	@JoinColumn(name="created_by")
	private User createdBy;


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

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public String getTinyUrl() {
		return tinyUrl;
	}

	public void setTinyUrl(String tinyUrl) {
		this.tinyUrl = tinyUrl;
	}

	public Timestamp getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
