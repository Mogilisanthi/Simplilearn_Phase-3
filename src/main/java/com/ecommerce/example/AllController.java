package com.ecommerce.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AllController {
	@Autowired
	ShoeDAO shoe_dao;
	@Autowired
	ShoeRepo shoe_repo;
	
	@Autowired
	AdminDAO ad_dao;
	@Autowired
	AdminRepo ad_repo;
	@Autowired
	UserDAO u_dao;
	@Autowired
	UserRepo u_repo;
	@Autowired
	BankRepo b_repo;
	@Autowired
	BankDAO b_dao;
	
	//Single Bank insert
		@PostMapping("/insert_bank")
		public Bank insert_bank(@RequestBody Bank b)
		{
			return b_dao.b_insert(b);
		}
		@PostMapping("/insert_bank_list")
		public List<Bank> insertall_ids(@RequestBody List<Bank> b) {

			return b_dao.insertall_ids(b);
		}

	//Single product insert
	@PostMapping("/insert_shoe")
	public Shoe insert_shoe(@RequestBody Shoe s)
	{
		return shoe_dao.insert_shoe(s);
	}

	//PRODUCT LIST Insert
	@PostMapping("/insert_shoe_list")
	public List<Shoe> insertall_shoes(@RequestBody List<Shoe> s) {

		return shoe_dao.insertall_shoes(s);
	}
	//Get PRODUCT LIST 
	@GetMapping("/get_all_shoe_list")
	public List<Shoe> getallshoes()
	{
		return shoe_dao.getallshoes();
	}
	
	@PutMapping("/update_shoe")
	public Shoe updateShoe(@RequestBody Shoe us) {
		return shoe_dao.updateShoe(us);
	}
	@DeleteMapping("/shoe_delete/{id}")
	public String deletebyid(@PathVariable int id) {
		return shoe_dao.deletebyid(id);

	}
	
	/* User operations start*/
	@PostMapping("/insert_user")
	public User user_insert(@RequestBody User u)
	{
		return u_dao.user_insert(u);
	}
	@PostMapping("/insert_userlist")
	public List<User> user_insertall(@RequestBody List<User> us)
	{
		return u_dao.user_insertall(us);
	}
	
	@GetMapping("/get_userlist")
	public List<User> user_getall()
	{
		return u_dao.user_getAll();
	}
	@GetMapping("/get_userbyname/{user_fname}")
	public List<User> findByName(@PathVariable String user_fname)throws Exception{

		if(u_dao.findByName(user_fname).isEmpty()) {
			throw new Exception("the name is not found");
			
		}
		else {
			return u_dao.findByName(user_fname);
		}

	}
	@PutMapping("/update_user")
	public User updateUser(@RequestBody User uu) {
		return u_dao.updateUser(uu);
	}
	@DeleteMapping("/user_delete/{id}")
	public String deleteuserbyid(@PathVariable int id) {
		return u_dao.deleteuserbyid(id);

	}
	
}

