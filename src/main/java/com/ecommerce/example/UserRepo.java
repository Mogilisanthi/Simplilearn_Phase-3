package com.ecommerce.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	@Query("select user from User user where user.user_fname=?1 and user.user_pass=?2")
	public User findbyfnamepass(String user_fname, String user_pass);
	
	@Query("select user from User user where user.user_fname=?1")
	public User findbyname(String user_fname);
	
	@Query("select u from User u where u.user_fname=?1")
	public List<User> findByName(String user_fname);
	
	@Query("select up from User up where up.user_phone=?1")
	public List<User> findByPhone(String user_phone);

}
