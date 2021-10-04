package ch.javaprofi_academy;

import org.springframework.beans.factory.annotation.Autowired;

public class SimpleCarByName {

	private CarPlaySpecial someOtherServiceBean;
	
	// SET METHOD MUSS SPEZIELL HEISSEN!!
	@Autowired
	public void setSomeOtherServiceBeanl(CarPlaySpecial carPlay) {
		this.someOtherServiceBean = carPlay;
	}
	
	@Override
	public String toString() {
		return "SimpleCarByName [carPlay=" + someOtherServiceBean + "]";
	}
}
