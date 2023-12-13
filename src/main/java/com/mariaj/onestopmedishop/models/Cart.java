package com.mariaj.onestopmedishop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "cart_details")
@SequenceGenerator(name="cart_seq", sequenceName = "cart_seq", initialValue =1, allocationSize = 1 )
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq")
	@Column(name="cart_id")
	private int cartId;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Transient
	private Medication product;

	public Cart() {

	}

	public Cart(int cartId, int productId, int userId, int quantity, Medication product) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
		this.product = product;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Medication getProduct() {
		return product;
	}

	public void setProduct(Medication product) {
		this.product = product;
	}
	
	
}
