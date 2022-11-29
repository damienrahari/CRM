package com.example.demoPOEC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoPOEC.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
