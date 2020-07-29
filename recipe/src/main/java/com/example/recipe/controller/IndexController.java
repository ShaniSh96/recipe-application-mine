package com.example.recipe.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.recipe.model.Category;
import com.example.recipe.model.UnitOfMeasure;
import com.example.recipe.repository.CategoryRepository;
import com.example.recipe.repository.UnitOfMeasureRepository;
import com.example.recipe.service.RecipeService;

@Controller
public class IndexController {
	
	private final RecipeService service;
	
	

	public IndexController(RecipeService service) {
		this.service = service;
	}



	@RequestMapping({" ","/","index","index.html"})
	public String getRecipeList(Model model) {
		
		model.addAttribute("recipeList", service.getRecipes());
		return "index";
		
	}
}
