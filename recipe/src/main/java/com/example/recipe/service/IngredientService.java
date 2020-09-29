package com.example.recipe.service;

import com.example.recipe.command.IngredientCommand;

public interface IngredientService {

	IngredientCommand findByRecipeIdAndId(Long recipeId, Long ingredientId);
	IngredientCommand saveIngredientCommand(IngredientCommand command);
	
	void deleteIngredient(Long recipeId, Long ingredientId);
}
