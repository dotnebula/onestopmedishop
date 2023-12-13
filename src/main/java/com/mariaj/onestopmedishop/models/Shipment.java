package com.mariaj.onestopmedishop.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "shipment_details")
@SequenceGenerator(name="shipment_seq", sequenceName = "shipment_seq", initialValue =1, allocationSize = 1 )
public class Shipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipment_seq")
	@Column(name="shipment_id")
	private int shipmentId;
	
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="shipment_status")
	private int shipmentStatus;
	
	@Column(name="shipment_title")
	private String shipmentTitle;
	
	@Column(name="shipment_date")
	private Date shipmentDate;
	
	@Column(name="expected_delivery_date")
	private Date expectedDeliveryDate;
	
	@Column(name="shipment_method")
	private String shipmentMethod;
	
	@Column(name="shipment_company")
	private String shipmentCompany;

	public Shipment() {
		super();
	}

	public Shipment(int shipmentId, int orderId, int shipmentStatus, String shipmentTitle, Date shipmentDate,
			Date expectedDeliveryDate, String shipmentMethod, String shipmentCompany) {
		super();
		this.shipmentId = shipmentId;
		this.orderId = orderId;
		this.shipmentStatus = shipmentStatus;
		this.shipmentTitle = shipmentTitle;
		this.shipmentDate = shipmentDate;
		this.expectedDeliveryDate = expectedDeliveryDate;
		this.shipmentMethod = shipmentMethod;
		this.shipmentCompany = shipmentCompany;
	}

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(int shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public String getShipmentTitle() {
		return shipmentTitle;
	}

	public void setShipmentTitle(String shipmentTitle) {
		this.shipmentTitle = shipmentTitle;
	}

	public Date getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public String getShipmentMethod() {
		return shipmentMethod;
	}

	public void setShipmentMethod(String shipmentMethod) {
		this.shipmentMethod = shipmentMethod;
	}

	public String getShipmentCompany() {
		return shipmentCompany;
	}

	public void setShipmentCompany(String shipmentCompany) {
		this.shipmentCompany = shipmentCompany;
	}
	
	

}
