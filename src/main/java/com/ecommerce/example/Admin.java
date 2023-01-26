package com.ecommerce.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ad_id;
	private String ad_fname;
	private String ad_lname;
	private String ad_phone;
	private String ad_mail;
	private String ad_dob;
	private String ad_pass;

}
