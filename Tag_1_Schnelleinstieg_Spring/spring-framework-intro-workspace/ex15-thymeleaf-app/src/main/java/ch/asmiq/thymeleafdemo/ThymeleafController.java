package ch.asmiq.thymeleafdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ch.asmiq.dao.PersonDAO;

@Controller
public class ThymeleafController {
	
	@Autowired
	PersonDAO personDao;
	
	@GetMapping("/home")
	public String index(Model model) {
		model.addAttribute("msg", "Greetings from Spring Boot to thymeleaf!");

		return "index";
	}

	
	@GetMapping(value="/personsList")
	public String getAllPersonsForModel(Model model){
		model.addAttribute("persons", personDao.getAllPersons());
		
		return "personsList";
	}
}