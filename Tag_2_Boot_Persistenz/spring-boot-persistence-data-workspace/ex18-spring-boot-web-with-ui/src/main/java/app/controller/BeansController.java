package app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BeansController {

	@Autowired
	ApplicationContext ctx;
	
	@GetMapping("/")
	public String index(Model model) {		
		model.addAttribute("msg", "Greetings from Spring Boot!");

		return "index";
	}

	// "/beans?startWith=<prefix>&endtWith=<postfix>"		
	@GetMapping("/beans")
	public String beans(@RequestParam("startsWith") Optional<String> prefix,
			@RequestParam("endsWith") Optional<String> postfix,
			@RequestParam("contains") Optional<String> textpart,
			Model model) {
		
		
		var filteredResult = retrievBeans(ctx).stream();
		
		if (prefix.isPresent())
			filteredResult = filteredResult.filter(str -> str.startsWith(prefix.get()));
	
		if (postfix.isPresent())
			filteredResult = filteredResult.filter(str -> str.endsWith(postfix.get()));
		
		if (textpart.isPresent())
			filteredResult = filteredResult.filter(str -> str.contains(textpart.get()));
		
		
		model.addAttribute("beans", filteredResult.collect(Collectors.toList()));
		model.addAttribute("isFiltered", prefix.isPresent() || postfix.isPresent() || textpart.isPresent());
		model.addAttribute("startsWith", prefix);
		model.addAttribute("endsWith", postfix);
		model.addAttribute("contains", textpart);

		return "beansList";
	}

	
	private List<String> retrievBeans(ApplicationContext ctx) {
		
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		
		return Arrays.stream(beanNames).collect(Collectors.toList());
	}	
}
