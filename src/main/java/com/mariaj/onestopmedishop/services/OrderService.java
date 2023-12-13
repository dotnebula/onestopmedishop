package com.mariaj.onestopmedishop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariaj.onestopmedishop.exceptions.BadRequestException;
import com.mariaj.onestopmedishop.exceptions.NotFoundException;
import com.mariaj.onestopmedishop.models.Order;
import com.mariaj.onestopmedishop.repositories.OrderRepository;
import com.mariaj.onestopmedishop.utilities.StringUtil;


@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	// Get all orders
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}
	
	// Get one order by orderId
	public Optional<Order> getOrder(int orderId) {
		Optional<Order> order= orderRepository.findById(orderId);
		if(order.isPresent() && StringUtil.isNotNull(order))
			return order;
		else 
			throw new NotFoundException("The order does not exist with provided orderId.");
	}
	
	// Add order
	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}
	
	// Update order
	public Order updateOrder(Order order) {
		if(order.getOrderId() <=0 )
			throw new BadRequestException("orderId cannot be null or empty.");
		if(orderRepository.existsById(order.getOrderId()))
			return orderRepository.save(order);
		else 
			throw new NotFoundException("The order does not exist with provided orderId.");
	}
	
	// Delete order
	public void deleteOrder(int orderId) {
		if(orderId <=0 )
			throw new BadRequestException("orderId cannot be null or empty.");
		if(orderRepository.existsById(orderId))
			orderRepository.deleteById(orderId);
		else 
			throw new NotFoundException("The order does not exist with provided orderId.");
	}
}
