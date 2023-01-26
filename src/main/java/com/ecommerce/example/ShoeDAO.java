package com.ecommerce.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShoeDAO {

	@Autowired
	ShoeRepo shoe_repo;

	//INSERT PRODUCT for restcontroller
	public Shoe insert_shoe(Shoe s)
	{
		return shoe_repo.save(s);
	}
	//insert list of products for restcontroller
	public List<Shoe> insertall_shoes(List<Shoe> s) {

		return shoe_repo.saveAll(s);
	}


	//Get PRODUCT LIST for restcontroller
	public List<Shoe> getallshoes()
	{
		return shoe_repo.findAll();
	}
	//delete product for restcontroller
	public String deletebyid(int id) {
		shoe_repo.deleteById(id);
		return "record got deleted" +id;
	}
    // update product for restcontroller
	public Shoe updateShoe(Shoe us) {
		
		Shoe existingProduct=shoe_repo.findById(us.getShoe_id()).orElse(null);
		existingProduct.setShoe_name(us.getShoe_name());
		existingProduct.setShoe_code(us.getShoe_code());
		existingProduct.setShoe_brand(us.getShoe_brand());
		existingProduct.setShoe_price(us.getShoe_price());
		existingProduct.setSell_date(us.getSell_date());
		shoe_repo.save(existingProduct);
		return existingProduct;

	}
	//delete product for controller
	public String delete(Shoe s) {
		shoe_repo.delete(s);
		return  "shoe record got deleted !!" ;
	}
	// update product for controller
		public Shoe Update_shoe(Shoe us) {
			
			Shoe existingProduct=shoe_repo.findById(us.getShoe_id()).orElse(null);
			existingProduct.setShoe_name(us.getShoe_name());
			existingProduct.setShoe_code(us.getShoe_code());
			existingProduct.setShoe_brand(us.getShoe_brand());
			existingProduct.setShoe_price(us.getShoe_price());
			existingProduct.setSell_date(us.getSell_date());
			shoe_repo.save(existingProduct);
			return existingProduct;

		}
	//SEARCH Shoe BY Sell Date
		public List<Shoe> findBySellDate(String sell_date)
		{
				return shoe_repo.getByDate(sell_date);
		}
		
		
	
}


