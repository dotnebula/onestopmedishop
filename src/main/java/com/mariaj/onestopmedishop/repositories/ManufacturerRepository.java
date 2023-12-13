package com.mariaj.onestopmedishop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mariaj.onestopmedishop.models.Manufacturer;


@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer>{

}
