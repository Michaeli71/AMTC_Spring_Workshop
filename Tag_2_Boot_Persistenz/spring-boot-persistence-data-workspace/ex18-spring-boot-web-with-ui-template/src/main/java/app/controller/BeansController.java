package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BeansController {
	
	@GetMapping("/")
	public String index(Model model) {		

		return "index";
	}

	// "/beans?startWith=<prefix>&endtWith=<postfix>"		
	@GetMapping("/beans")
	public String beans(Model model) {
		
		return "beansList";
	}
}
