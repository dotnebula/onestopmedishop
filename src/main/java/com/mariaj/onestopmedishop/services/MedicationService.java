package com.mariaj.onestopmedishop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mariaj.onestopmedishop.models.Medication;
import com.mariaj.onestopmedishop.repositories.MedicationRepository;



@Service
public class MedicationService {

	@Autowired
	MedicationRepository medicationRepository;

	public Page<Medication> getMedications(int page, int size, String sort, String sortOrder) {
		Sort.Direction direction = sortOrder.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
		Sort sortBy = Sort.by(direction,sort);
		Pageable pageable = PageRequest.of(page, size, sortBy);
		return medicationRepository.findAll(pageable);
	}

	public Medication getMedication(int medicationId) {
		return medicationRepository.findById(medicationId).get();
	}

	public Medication addMedication(Medication medication) {
		return medicationRepository.save(medication);
	}

	public Medication updateMedication(Medication medication) {
		if(medicationRepository.existsById(medication.getMedicationId()))
			return medicationRepository.save(medication);
		else 
			return null;
	}

	public void deleteMedication(int medicationId) {
		medicationRepository.deleteById(medicationId);
	}
	
}
