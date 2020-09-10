package com.example.recipe.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.example.recipe.model.Recipe;
import com.example.recipe.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{

	private final RecipeRepository repo;

	public RecipeServiceImpl(RecipeRepository repo) {
		this.repo = repo;
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
	
	
	
	
	
}
