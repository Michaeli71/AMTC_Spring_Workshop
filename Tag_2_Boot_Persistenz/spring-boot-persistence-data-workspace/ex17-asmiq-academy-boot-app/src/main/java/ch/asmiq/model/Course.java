package ch.asmiq.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

//
@XmlRootElement(name="course")
public class Course {

	private String name;
	private int days;
	private BigDecimal price;

	public Course() {
	}

	public Course(String name, int quantity, BigDecimal price) {
		this.name = name;
		this.days = quantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return days;
	}

	public void setQuantity(int quantity) {
		this.days = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
