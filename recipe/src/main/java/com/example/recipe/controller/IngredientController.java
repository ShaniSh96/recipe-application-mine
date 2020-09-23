package com.example.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.recipe.service.IngredientService;
import com.example.recipe.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IngredientController {

	private final RecipeService recipeService;
	private final IngredientService ingredientService;
	
	public IngredientController(RecipeService recipeService, IngredientService ingredientService) {
		this.recipeService = recipeService;
		this.ingredientService = ingredientService;
	}
	
	@RequestMapping("/recipe/{id}/ingredients")
	public String listIngredient(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findCommandByID(Long.valueOf(id)));
		
		return "recipe/ingredient/list";
	}
	
	@RequestMapping("/recipe/{recipeId}/ingredient/{ingredienetId}/show")
	public String showRecipeIngredient(@PathVariable String recipeId, 
									  @PathVariable String ingredienetId, Model model) {
		model.addAttribute("ingredient", ingredientService.findByRecipeIdAndId(Long.valueOf(recipeId), Long.valueOf(ingredienetId)));
		return "recipe/ingredient/show";
	}
}
