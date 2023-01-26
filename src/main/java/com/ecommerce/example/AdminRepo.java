package com.ecommerce.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin, Integer>{
	@Query("select admin from Admin admin where admin.ad_fname=?1 and admin.ad_pass=?2")
	public Admin findbyfnamepass(String ad_fname, String ad_pass);

	@Query("select admin from Admin admin where admin.ad_fname=?1")
	public List<Admin> findbyname(String ad_fname);

	@Query("select ad from Admin ad where ad.ad_phone=?1")
	public List<Admin> findByAdPhone(String ad_phone);

	@Query("select ad from Admin ad where ad.ad_pass=?1")
	public String findByAdPassword(String ad_pass);




}


