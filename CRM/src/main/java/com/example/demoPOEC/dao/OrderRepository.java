package com.example.demoPOEC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoPOEC.model.Order;



public interface OrderRepository extends JpaRepository<Order, Integer> {

}
