package com.mariaj.onestopmedishop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mariaj.onestopmedishop.exceptions.NotFoundException;
import com.mariaj.onestopmedishop.models.Manufacturer;
import com.mariaj.onestopmedishop.repositories.ManufacturerRepository;
import com.mariaj.onestopmedishop.utilities.StringUtil;



@Service
public class ManufacturerService {

	@Autowired
	ManufacturerRepository manufacturerRepository;

	public Page<Manufacturer> getManufacturers(int page, int size, String sort, String sortOrder) {
		Sort.Direction direction = sortOrder.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
		Sort sortBy = Sort.by(direction,sort);
		Pageable pageable = PageRequest.of(page, size, sortBy);
		return manufacturerRepository.findAll(pageable);
	}

	public Optional<Manufacturer> getManufacturer(int manufacturerId) {
		Optional<Manufacturer> manufacturer = manufacturerRepository.findById(manufacturerId);
		if(StringUtil.isNotNull(manufacturer) && manufacturer.isPresent())
			return manufacturer;
		else
			throw new NotFoundException("The manufacturer does not exist with provided manufacturerId.");
	}

	public Manufacturer addManufacturer(Manufacturer manufacturer) {
		return manufacturerRepository.save(manufacturer);
	}

	public Manufacturer updateManufacturer(Manufacturer manufacturer) {
		if(manufacturerRepository.existsById(manufacturer.getManufacturerId()))
			return manufacturerRepository.save(manufacturer);
		else 
			throw new NotFoundException("The manufacturer does not exist with provided manufacturerId.");
	}

	public void deleteManufacturer(int manufacturerId) {
		if(manufacturerRepository.existsById(manufacturerId))
			manufacturerRepository.deleteById(manufacturerId);
		else 
			throw new NotFoundException("The manufacturer does not exist with provided manufacturerId.");
	}
}
