package com.mariaj.onestopmedishop.controllers;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mariaj.onestopmedishop.dto.ResponseDto;
import com.mariaj.onestopmedishop.models.Manufacturer;
import com.mariaj.onestopmedishop.services.ManufacturerService;


@RestController
public class ManufacturerController {

	@Autowired 
	ManufacturerService manufacturerService;

	@GetMapping("/manufacturers")
	public Page<Manufacturer> getCategorys(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, 
			@RequestParam(defaultValue = "manufacturerId") String sort, @RequestParam(defaultValue = "ASC") String sortOrder){
		return manufacturerService.getManufacturers(page,size, sort, sortOrder);
	}
	
	@GetMapping("/manufacturers/{manufacturerId}")
	public Optional<Manufacturer> getManufacturer(@PathVariable int manufacturerId){
		return manufacturerService.getManufacturer(manufacturerId);
	}

	@PostMapping("/manufacturers")
	public Manufacturer addManufacturer(@RequestBody Manufacturer manufacturer){
		return manufacturerService.addManufacturer(manufacturer);
	}

	@PutMapping("/manufacturers")
	public Manufacturer updateManufacturer(@RequestBody Manufacturer manufacturer){
		return manufacturerService.updateManufacturer(manufacturer);
	}
	
	@DeleteMapping("/manufacturers/{manufacturerId}")
	public ResponseDto updateManufacturer(@PathVariable int manufacturerId){
		manufacturerService.deleteManufacturer(manufacturerId);
		return new ResponseDto("Mmanufacturer is deleted sucessfully with manufacturerId : "+manufacturerId, new Date(),HttpStatus.OK.name(),null);
	}
}
