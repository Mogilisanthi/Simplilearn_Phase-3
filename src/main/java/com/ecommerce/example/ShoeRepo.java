package com.ecommerce.example;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoeRepo extends JpaRepository<Shoe, Integer> {
	
	@Query("select sh from Shoe sh where sh.sell_date=?1")
	public List<Shoe> getByDate(String sell_date);
	@Query("select sh from Shoe sh where sh.shoe_id=?1")
	public List<Shoe> getById(int id);

}
