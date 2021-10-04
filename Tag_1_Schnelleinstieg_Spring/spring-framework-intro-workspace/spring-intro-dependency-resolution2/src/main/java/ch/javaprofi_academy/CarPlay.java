package ch.javaprofi_academy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Primary
@Component("carPlay")
public class CarPlay implements AudioPlayer { 
	String info;


	public CarPlay() {
		super();
		this.info = "n/a";
	}
	
	public CarPlay(String info) {
		super();
		this.info = info;
	}
	
	
}
