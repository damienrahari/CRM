package com.example.demoPOEC.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String type_presta;
	private String designation;
	private Integer nb_days;
	private String unit_price;
	
	@ManyToOne
    private Client client;

	public Order() {
	}

	public Order(String type_presta, String designation, Integer nb_days, String unit_price) {
		this.type_presta = type_presta;
		this.designation = designation;
		this.nb_days = nb_days;
		this.unit_price = unit_price;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType_presta() {
		return type_presta;
	}

	public void setType_presta(String type_presta) {
		this.type_presta = type_presta;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getNb_days() {
		return nb_days;
	}

	public void setNb_days(Integer nb_days) {
		this.nb_days = nb_days;
	}

	public String getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}
	//RELATION
	public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

	@Override
	public String toString() {
		return "Order [id=" + id + ", type_presta=" + type_presta + ", designation=" + designation + ", nb_days="
				+ nb_days + ", unit_price=" + unit_price + "]";
	}
	

}
