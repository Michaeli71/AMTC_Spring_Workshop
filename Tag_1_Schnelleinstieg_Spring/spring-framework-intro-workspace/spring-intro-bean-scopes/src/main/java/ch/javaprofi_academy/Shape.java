package ch.javaprofi_academy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Shape {

	private String color = "yellow";

	@Override
	public String toString() {
		return "Shape [color=" + color + "]";
	}

	public void setColor(String color) {
		this.color = color;	
	}
	
	// shape

	
}
