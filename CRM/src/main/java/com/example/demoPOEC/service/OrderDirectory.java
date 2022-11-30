package com.example.demoPOEC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoPOEC.dao.OrderRepository;
import com.example.demoPOEC.model.Order;

@Service
public class OrderDirectory {
	@Autowired
	private OrderRepository orderRepository;
	public void addOrder(Order newOrder) {
		orderRepository.save(newOrder);
	}

	public List<Order> getOrders() {
		return orderRepository.findAll();
	}


	
	public Optional<Order> getOrder(Integer id) {
				return orderRepository.findById(id);
			
	}


	public void deleteOrder(Integer id) {
		orderRepository.deleteById(id);
	}

		public void updateOrder(Order orderToUpdate, Integer id) {
			orderRepository.save(orderToUpdate);
		}


}
