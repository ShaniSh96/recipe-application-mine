package com.example.recipe.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.recipe.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long>{

}
