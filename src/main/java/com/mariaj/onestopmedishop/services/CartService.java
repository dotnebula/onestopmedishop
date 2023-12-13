package com.mariaj.onestopmedishop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariaj.onestopmedishop.exceptions.BadRequestException;
import com.mariaj.onestopmedishop.exceptions.NotFoundException;
import com.mariaj.onestopmedishop.models.Cart;
import com.mariaj.onestopmedishop.models.Medication;
import com.mariaj.onestopmedishop.repositories.CartRepository;
import com.mariaj.onestopmedishop.repositories.MedicationRepository;
import com.mariaj.onestopmedishop.utilities.StringUtil;


@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	MedicationRepository medicationRepository;

	// Get all carts
	public List<Cart> getCarts() {
		List<Cart> cartItesm =  cartRepository.findAll();
		if (!cartItesm.isEmpty()) {
			cartItesm.forEach( it ->{
				Optional<Medication> product = medicationRepository.findById(it.getProductId());
				if (product.isPresent()) {
					it.setProduct(product.get());
				}
			});
		} 
		return cartItesm;
	}

	// Get one cart by cartId
	public Optional<Cart> getCart(int cartId) {
		Optional<Cart> cart = cartRepository.findById(cartId);
		if (cart.isPresent() && StringUtil.isNotNull(cart)) {
			Optional<Medication> product = medicationRepository.findById(cart.get().getProductId());
			if (product.isPresent()) {
				cart.get().setProduct(product.get());
			}
			return cart;
		} else
			throw new NotFoundException("The cart details does not exist with provided cartId.");
	}

	// Get one cart by cartId
	public List<Cart> getCartByUserId(int userId) {
		List<Cart> cartItesm = cartRepository.findByUserId(userId);
		if (!cartItesm.isEmpty()) {
			cartItesm.forEach( it ->{
				Optional<Medication> product = medicationRepository.findById(it.getProductId());
				if (product.isPresent()) {
					it.setProduct(product.get());
				}
			});
			return cartItesm;
		} else
			throw new NotFoundException("The cart details does not exist with provided userId.");
	}

	// Add cart
	public Cart addCart(Cart cart) {
		return cartRepository.save(cart);
	}

	// Update cart
	public Cart updateCart(Cart cart) {
		if (cart.getCartId() <= 0)
			throw new BadRequestException("cartId id cannot be null or empty.");
		if (cartRepository.existsById(cart.getCartId()))
			return cartRepository.save(cart);
		else
			throw new NotFoundException("The cart details does not exist with provided cartId.");
	}

	// Delete cart
	public void deleteCart(int cartId) {
		if (cartId <= 0)
			throw new BadRequestException("cartId id cannot be null or empty.");
		if (cartRepository.existsById(cartId))
			cartRepository.deleteById(cartId);
		else
			throw new NotFoundException("The cart details does not exist with provided cartId.");
	}
}
