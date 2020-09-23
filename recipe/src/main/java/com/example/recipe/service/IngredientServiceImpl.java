package com.example.recipe.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.recipe.command.IngredientCommand;
import com.example.recipe.converter.IngredientToIngredientCommand;
import com.example.recipe.model.Recipe;
import com.example.recipe.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService{

	private final IngredientToIngredientCommand command;
	private final RecipeRepository repo;
	
	public IngredientServiceImpl(IngredientToIngredientCommand command, RecipeRepository repo) {
		this.command = command;
		this.repo = repo;
	}

	@Override
	public IngredientCommand findByRecipeIdAndId(Long recipeId, Long ingredientId) {
		Optional<Recipe> optionalRecipe = repo.findById(recipeId);
		
		Recipe recipe = optionalRecipe.get();
		
		Optional<IngredientCommand> optionalIngredient = recipe.getIngredients().stream()
																		 .filter(ingredient -> ingredient.getId().equals(ingredientId))
																		 .map(ingredient -> command.convert(ingredient))
																		 .findFirst();
		
		return optionalIngredient.get();
	}
	
}
