package com.ecommerce.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankDAO {
	
	@Autowired
	BankRepo b_repo;
	
	public Bank b_insert(Bank b)
	{
		return b_repo.save(b);
	}
	//insert list of bank id's for restcontroller
		public List<Bank> insertall_ids(List<Bank> b) {

			return b_repo.saveAll(b);
		}

}
