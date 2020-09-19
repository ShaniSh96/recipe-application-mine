package com.example.recipe.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.recipe.command.CategoryCommand;
import com.example.recipe.command.IngredientCommand;
import com.example.recipe.command.NotesCommand;
import com.example.recipe.command.RecipeCommand;
import com.example.recipe.model.Recipe;

import lombok.Synchronized;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
	
	
	private final CategoryCommandToCategory categoryCmommand;
	private final IngredientCommandToIngredient ingredientCommand;
	private final NotesCommandToNotes notesCommand;
	

	public RecipeCommandToRecipe(CategoryCommandToCategory categoryCmommand,
			IngredientCommandToIngredient ingredientCommand, NotesCommandToNotes notesCommand) {
		this.categoryCmommand = categoryCmommand;
		this.ingredientCommand = ingredientCommand;
		this.notesCommand = notesCommand;
	}




	@Synchronized
	@Nullable
	@Override
	public Recipe convert(RecipeCommand source) {
		if(source == null)
			return null;
		
		Recipe recipe = new Recipe();
		recipe.setId(source.getId());
		recipe.setDescription(source.getDescription());
		recipe.setCookTime(source.getCookTime());
		recipe.setDifficulty(source.getDifficulty());
		recipe.setDirections(source.getDirections());
		recipe.setPerpTime(source.getPrepTime());
		recipe.setServeings(source.getServings());
		recipe.setSource(source.getSource());
		recipe.setUrl(source.getUrl());
		recipe.setNotes(notesCommand.convert(source.getNotes()));
		
		if(source.getCategories() != null && source.getCategories().size() > 0) {
			source.getCategories().forEach(category -> recipe.getCategories().add(categoryCmommand.convert(category)));
		}
		
		
		if(source.getIngredients() != null && source.getIngredients().size() > 0) {
			source.getIngredients().forEach(indgredient -> recipe.getIngredients().add(ingredientCommand.convert(indgredient)));
		}
		
		return recipe;
		
	}

}
