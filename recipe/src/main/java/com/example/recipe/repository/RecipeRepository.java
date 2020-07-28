package com.example.recipe.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.recipe.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

	
}
