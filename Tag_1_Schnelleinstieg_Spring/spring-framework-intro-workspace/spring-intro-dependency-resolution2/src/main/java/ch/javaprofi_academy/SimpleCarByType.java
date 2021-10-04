package ch.javaprofi_academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SimpleCarByType {

	@Autowired
	@Qualifier("androidAuto")
	private AudioPlayer audioPlayer;

	@Override
	public String toString() {
		return "SimpleCarByType [audioPlayer=" + audioPlayer + "]";
	}
}
