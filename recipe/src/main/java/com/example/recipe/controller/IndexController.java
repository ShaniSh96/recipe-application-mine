package com.example.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.recipe.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	
	private final RecipeService service;
	
	

	public IndexController(RecipeService service) {
		this.service = service;
	}



	@RequestMapping({" ","/","index","index.html"})
	public String getRecipeList(Model model) {
		log.debug("In Index Controller");
		model.addAttribute("recipeList", service.getRecipes());
		return "index";
		
	}
}
