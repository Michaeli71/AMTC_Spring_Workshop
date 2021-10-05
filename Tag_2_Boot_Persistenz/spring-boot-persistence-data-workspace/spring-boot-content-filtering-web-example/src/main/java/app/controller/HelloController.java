package app.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	// "/names?startWith=<prefix>&endtWith=<postfix>"
	@GetMapping("/names")
	public List<String> names(@RequestParam("startsWith") Optional<String> prefix,
						@RequestParam("endsWith") Optional<String> postfix) {
		
		var filteredResult = Stream.of("Tim", "Tom", "Mike", "Michael", "Jim", "John", "James");
		
		if (prefix.isPresent())
			filteredResult = filteredResult.filter(str -> str.startsWith(prefix.get()));
	
		if (postfix.isPresent())
			filteredResult = filteredResult.filter(str -> str.endsWith(postfix.get()));
		
		return filteredResult.collect(Collectors.toList());
	}
}