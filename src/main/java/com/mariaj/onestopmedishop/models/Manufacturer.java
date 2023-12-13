package com.mariaj.onestopmedishop.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name="manufacturers")
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="manufacturer_id")
	private int manufacturerId;
	
	@Column(name="name")
	private String manufacturerName;
	
	@Column(name="license")
	private String manufacturerLicense;
	
	@Column(name="address")
	private String address;
	
	@Column(name="manufacturer_Logo_url")
	private String manufacturerLogoUrl;
	
	@Column(name="active")
	private int active;
	
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
	
//	@OneToMany(mappedBy="mediManufacturer", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	private List<Product> manufacturedMedications;

	public Manufacturer() {

	}

	public Manufacturer(int manufacturerId, String manufacturerName, String manufacturerLicense, String address,
			String manufacturerLogoUrl, int active, Date createdAt, Date updatedAt
//			,
//			List<Product> manufacturedMedications
			) {
		super();
		this.manufacturerId = manufacturerId;
		this.manufacturerName = manufacturerName;
		this.manufacturerLicense = manufacturerLicense;
		this.address = address;
		this.manufacturerLogoUrl = manufacturerLogoUrl;
		this.active = active;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
//		this.manufacturedMedications = manufacturedMedications;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturerLicense() {
		return manufacturerLicense;
	}

	public void setManufacturerLicense(String manufacturerLicense) {
		this.manufacturerLicense = manufacturerLicense;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getManufacturerLogoUrl() {
		return manufacturerLogoUrl;
	}

	public void setManufacturerLogoUrl(String manufacturerLogoUrl) {
		this.manufacturerLogoUrl = manufacturerLogoUrl;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
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

//	public List<Product> getManufacturedMedications() {
//		return manufacturedMedications;
//	}
//
//	public void setManufacturedMedications(List<Product> manufacturedMedications) {
//		this.manufacturedMedications = manufacturedMedications;
//	}

	

	
	
}
