package com.andiads.nusabank.api.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping(value = "/")
	public String goHome(@RequestParam(name="name", required=false, defaultValue="World")String name, Model model) {
		model.addAttribute("name", name);
		return "home";
	}
}
