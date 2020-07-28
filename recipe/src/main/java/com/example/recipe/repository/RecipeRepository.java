package com.example.recipe.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.recipe.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{
	/*
	 * Recipe findById(Long id);
	 * 
	 * Recipe findByTitle(String title);
	 * 
	 * Set<Recipe> findAll();
	 * 
	 * Recipe save(Recipe recipe);
	 * 
	 * void delete(Recipe recipe);
	 * 
	 * void deleteAll();
	 */
	
}
