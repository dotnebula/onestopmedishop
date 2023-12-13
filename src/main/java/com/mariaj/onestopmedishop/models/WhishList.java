package com.mariaj.onestopmedishop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "whishlist_details")
@SequenceGenerator(name="whishlist_seq", sequenceName = "whishlist_seq", initialValue =1, allocationSize = 1 )
public class WhishList {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "whishlist_seq")
	@Column(name="wishlist_id")
	private int wishlistId;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="user_id")
	private int userId;
	
	@Transient
	private Medication products;

	public WhishList() {
		
	}

	public WhishList(int wishlistId, int productId, int userId, Medication products) {
		super();
		this.wishlistId = wishlistId;
		this.productId = productId;
		this.userId = userId;
		this.products = products;
	}

	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
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

	public Medication getProducts() {
		return products;
	}

	public void setProducts(Medication products) {
		this.products = products;
	}
	
	
}
