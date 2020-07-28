package com.example.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping({" ","/","index","index.html"})
	public String getRecipeList(Model model) {
		return "index";
		
	}
}
