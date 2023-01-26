package com.ecommerce.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {
	@Autowired
	UserRepo u_repo;
	
	//USER-INSERTION-CODE
	public User user_insert(User u)
	{
		return u_repo.save(u);
	}
public List<User> user_insertall(List<User> us) {
		
		return u_repo.saveAll(us);
	}
	
	//GET-REGISTERED-UER'S-LIST
public List<User> user_getAll() {
	// TODO Auto-generated method stub
	return u_repo.findAll();
}
	
	//SEARCH USER BY FIRST NAME
	public List<User> findByName(String user_fname)
	{
			return u_repo.findByName(user_fname);
	}
	
	//THIS CODE GIVES RETURN PASSWORD FOR USER USING PHONE NUMBER
	public List<User> forget_pass(String user_phone)
	{
		return u_repo.findByPhone(user_phone);
	}	
	
	
	
	public User updateUser(User uu) {
		User existingUser=u_repo.findById(uu.getUser_id()).orElse(null);
		existingUser.setUser_fname(uu.getUser_fname());
		existingUser.setUser_lname(uu.getUser_lname());
		existingUser.setUser_phone(uu.getUser_phone());
		existingUser.setUser_mail(uu.getUser_mail());
		existingUser.setUser_dob(uu.getUser_dob());
		existingUser.setUser_pass(uu.getUser_pass());
		u_repo.save(existingUser);
		return existingUser;
	}
	public String deleteuserbyid(int id) {
	    u_repo.deleteById(id);
		return  "user record got deleted !!" +id;
	}

	}


