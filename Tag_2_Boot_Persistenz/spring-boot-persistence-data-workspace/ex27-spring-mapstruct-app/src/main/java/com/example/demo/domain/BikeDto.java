package com.example.demo.domain;

public class BikeDto {

	private String brand;
	private String type;

	public BikeDto(String brand, String type) {
		this.brand = brand;
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
