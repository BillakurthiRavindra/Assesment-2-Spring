package com.itc.main.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itc.main.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{


	Product getProductByPname(String pname);
	@Transactional
	@Modifying
	@Query("DELETE FROM Product WHERE pname=:pname")
	     Integer deleteProductByName(String pname);


}
