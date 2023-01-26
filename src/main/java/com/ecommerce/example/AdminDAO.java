package com.ecommerce.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDAO {
	
	@Autowired
	AdminRepo ad_repo;
	
	//REGISTREATION-OF-ADMIN
		public Admin ad_insert(Admin a)
		{
			return ad_repo.save(a);
		}	
		
		
		
		
	

}
