package com.example.demo.entities;

public class Bike {

	private String brand;
	private BikeType type;


	public Bike(String brand, BikeType type) {
		this.brand = brand;
		this.type = type;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public BikeType getType() {
		return type;
	}


	public void setType(BikeType type) {
		this.type = type;
	}	
}
