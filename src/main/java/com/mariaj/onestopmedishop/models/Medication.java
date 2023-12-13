package com.mariaj.onestopmedishop.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "medications")
public class Medication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="medication_id")
	private int medicationId;
	
	@Column(name="medication_title")
	private String medicationTitle;
	
	@Column(name="medication_description")
	private String medicationDescription;
	
	@Column(name="medication_code")
	private String medicationCode;
	
	@Column(name="medication_price")
	private int price;
	
	@ElementCollection
	@CollectionTable(name = "medication_images", joinColumns =@JoinColumn(name = "medication_id"))
	@Column(name="image_url")
	private List<String> images = new ArrayList<>();

	@Column(name="thumbnail_image")
	private int thumbnailImage;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}
	
	@ManyToOne
	@JoinColumn(name = "manufacturer_id")
	private Manufacturer mediManufacturer;

	public Medication() {
		
	}

	public Medication(int medicationId, String medicationTitle, String medicationDescription, String medicationCode,
			int price, List<String> images, int thumbnailImage, Date createdAt, Date updatedAt,
			Manufacturer mediManufacturer) {
		super();
		this.medicationId = medicationId;
		this.medicationTitle = medicationTitle;
		this.medicationDescription = medicationDescription;
		this.medicationCode = medicationCode;
		this.price = price;
		this.images = images;
		this.thumbnailImage = thumbnailImage;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.mediManufacturer = mediManufacturer;
	}

	public int getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(int medicationId) {
		this.medicationId = medicationId;
	}

	public String getMedicationTitle() {
		return medicationTitle;
	}

	public void setMedicationTitle(String medicationTitle) {
		this.medicationTitle = medicationTitle;
	}

	public String getMedicationDescription() {
		return medicationDescription;
	}

	public void setMedicationDescription(String medicationDescription) {
		this.medicationDescription = medicationDescription;
	}

	public String getMedicationCode() {
		return medicationCode;
	}

	public void setMedicationCode(String medicationCode) {
		this.medicationCode = medicationCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public int getThumbnailImage() {
		return thumbnailImage;
	}

	public void setThumbnailImage(int thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Manufacturer getMediManufacturer() {
		return mediManufacturer;
	}

	public void setMediManufacturer(Manufacturer mediManufacturer) {
		this.mediManufacturer = mediManufacturer;
	}

	
	
	
}
