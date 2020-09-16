package com.socgen.bookmark.sgbookmark.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user_details", schema = "tinyurl")
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="USER_DETAILS_ID_GENERATOR", sequenceName = "tinyurl.user_details_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_DETAILS_ID_GENERATOR")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="last_login")
	private Date lastLogin;
	
	@Column(name="isactive")
	private Boolean isActive;
}
