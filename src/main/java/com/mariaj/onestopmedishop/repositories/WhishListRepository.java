package com.mariaj.onestopmedishop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mariaj.onestopmedishop.models.WhishList;


@Repository
public interface WhishListRepository extends JpaRepository<WhishList, Integer>{

}
