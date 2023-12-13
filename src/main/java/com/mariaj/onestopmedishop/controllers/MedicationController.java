package com.mariaj.onestopmedishop.controllers;

import java.util.Date;
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
import com.mariaj.onestopmedishop.models.Medication;
import com.mariaj.onestopmedishop.services.MedicationService;



@RestController
public class MedicationController {

	@Autowired 
	MedicationService medicationService;
	
	@GetMapping("/medications")
	public Page<Medication> getMedications(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "medicationId") String sort, @RequestParam(defaultValue = "ASC") String sortOrder){
		return medicationService.getMedications(page,size,sort, sortOrder);
	}
	
	@GetMapping("/medications/{medicationId}")
	public Medication getMedication(@PathVariable int medicationId){
		return medicationService.getMedication(medicationId);
	}
	
	@PostMapping("/medications")
	public Medication addMedication(@RequestBody Medication medication){
		return medicationService.addMedication(medication);
	}
	
	@PutMapping("/medications")
	public Medication updateMedication(@RequestBody Medication medication){
		return medicationService.updateMedication(medication);
	}
	
	@DeleteMapping("/medications/{medicationId}")
	public ResponseDto updateMedication(@PathVariable int medicationId){
		medicationService.deleteMedication(medicationId);
		return new ResponseDto("Medication is deleted sucessfully with pedicationId : "+ medicationId, new Date(), HttpStatus.OK.name(), null);
	}
}
