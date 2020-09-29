package com.example.recipe.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.recipe.command.RecipeCommand;
import com.example.recipe.converter.RecipeCommandToRecipe;
import com.example.recipe.converter.RecipeToRecipeCommand;
import com.example.recipe.model.Recipe;
import com.example.recipe.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{

	private final RecipeRepository repo;
	private final RecipeCommandToRecipe recipeCommandToRecipe;
	private final RecipeToRecipeCommand recipeToRecipeCommand;

	

	public RecipeServiceImpl(RecipeRepository repo, RecipeCommandToRecipe recipeCommandToRecipe,
			RecipeToRecipeCommand recipeToRecipeCommand) {
		this.repo = repo;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
	}

	@Override
	public Set<Recipe> getRecipes() {
		log.debug("I'm in my service");
		Set<Recipe> myRecipe = new HashSet<>();
		
		repo.findAll().forEach(recipe -> myRecipe.add(recipe));
		return myRecipe;
	}

	@Override
	public Recipe findById(Long id) {
		Optional<Recipe> recipe = repo.findById(id);
		if(!recipe.isPresent()) {
			throw new RuntimeException("Recipe not found!");
		}
		return recipe.get();
	}

	@Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

        Recipe savedRecipe = repo.save(detachedRecipe);
        log.debug("Saved RecipeId:" + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }

	@Transactional
	@Override
	public RecipeCommand findCommandByID(Long id) {
		return recipeToRecipeCommand.convert(findById(id));
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	
	
	
}
