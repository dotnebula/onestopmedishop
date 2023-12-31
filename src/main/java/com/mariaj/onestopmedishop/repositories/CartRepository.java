package com.mariaj.onestopmedishop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mariaj.onestopmedishop.models.Cart;



@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	// defined custom query 
	// 1) @Query provide HQL  2) Derived Query
	
	// 1) @Query provide HQL
	@Query("FROM Cart car where car.userId =:userId")
	List<Cart> findCartItemsByUserId(int userId);
	
	// 2) Derived Query
	List<Cart> findByUserId(int userId);

	List<Cart> findByUserIdAndProductId(int userId, int productId);
}
