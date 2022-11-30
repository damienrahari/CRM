package com.example.demoPOEC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoPOEC.model.Order;
import com.example.demoPOEC.service.OrderDirectory;

@RestController
@RequestMapping("api")
public class OrderContreller {
	@Autowired
	private OrderDirectory orderDirectory;
//------------------------------------------------------------------------------------------

	@GetMapping("orders")
	public List<Order> getOrder() {

		return orderDirectory.getOrders();
	}
//------------------------------------------------------------------------------------------

	@GetMapping("order/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable("id") Integer id) {
		Optional<Order> optionalOrder= orderDirectory.getOrder(id);
		if (optionalOrder.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(optionalOrder.get());
		}
	}
//------------------------------------------------------------------------------------------

	@PostMapping("orders")
	public Order addOrder(@RequestBody Order newOrder) {
		orderDirectory.addOrder(newOrder);
		return newOrder;
	}
//------------------------------------------------------------------------------------------

	@DeleteMapping("order/{id}")
	public void deleteOrder(@PathVariable("id") Integer id) {
		orderDirectory.deleteOrder(id);
	}
//------------------------------------------------------------------------------------------

	
	@PatchMapping("order/{id}")
	public void updateOrder(@RequestBody Order order, @PathVariable("id") Integer id) {
		orderDirectory.updateOrder(order, id);
	}
}
