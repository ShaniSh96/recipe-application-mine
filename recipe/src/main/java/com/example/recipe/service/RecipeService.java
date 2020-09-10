package com.example.recipe.service;

import java.util.Set;

import com.example.recipe.model.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();
	
	Recipe findById(Long id);
}
