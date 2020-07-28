package com.example.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.recipe.repository.RecipeRepository;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

	private final RecipeRepository repo;

	public RecipeController(RecipeRepository repo) {
		this.repo = repo;
	}
	
	@RequestMapping({"","/", "/index","index.html"})
	public String getRecipeList(Model model) {
		
		model.addAttribute("myrecipe", repo.findAll());
		
		return "recipe";
		
	}
	
}
