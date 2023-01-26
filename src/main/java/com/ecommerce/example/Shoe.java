package com.ecommerce.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class Shoe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shoe_id;
	private String shoe_code;
	private String shoe_name;
	private String shoe_brand;
	private String shoe_price;
	private String sell_date;
	

}
