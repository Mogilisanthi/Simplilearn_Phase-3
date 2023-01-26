package com.ecommerce.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BankRepo extends JpaRepository<Bank, Integer> {
	
	@Query("select b from Bank b where b.bank_Id=?1 and b.Bank_balance=2")
	public List<Bank> getByIdAndBalance(int bank_Id,String Bank_balance);

}
