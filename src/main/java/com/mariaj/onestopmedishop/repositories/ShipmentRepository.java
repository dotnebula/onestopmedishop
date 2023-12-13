package com.mariaj.onestopmedishop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mariaj.onestopmedishop.models.Shipment;



@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer>{

}
