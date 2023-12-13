package com.mariaj.onestopmedishop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mariaj.onestopmedishop.models.Admin;



@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	boolean existsByEmail(String email);

	Admin findByEmail(String email);

}
