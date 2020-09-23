package com.example.recipe.service;

import java.util.Set;

import com.example.recipe.command.RecipeCommand;
import com.example.recipe.model.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();
	
	Recipe findById(Long id);
	
	RecipeCommand findCommandByID(Long id);
	
	RecipeCommand saveRecipeCommand(RecipeCommand command);
	
	void deleteById(Long id);
}
