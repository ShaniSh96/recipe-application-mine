package com.example.recipe.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.recipe.command.IngredientCommand;
import com.example.recipe.converter.IngredientCommandToIngredient;
import com.example.recipe.converter.IngredientToIngredientCommand;
import com.example.recipe.model.Ingredient;
import com.example.recipe.model.Recipe;
import com.example.recipe.repository.IngredientRepository;
import com.example.recipe.repository.RecipeRepository;
import com.example.recipe.repository.UnitOfMeasureRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService{

	private final IngredientToIngredientCommand command;
	private final RecipeRepository repo;
	private final IngredientRepository ingredientRepo;
	private final IngredientCommandToIngredient ingredientCommandToIngredient;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	
	public IngredientServiceImpl(IngredientToIngredientCommand command, RecipeRepository repo, IngredientRepository ingredientRepo,IngredientCommandToIngredient ingredientCommandToIngredient,
						UnitOfMeasureRepository unitOfMeasureRepository) {
		this.command = command;
		this.repo = repo;
		this.ingredientRepo = ingredientRepo;
		this.ingredientCommandToIngredient = ingredientCommandToIngredient;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
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
	
	
	@Override
    @Transactional
    public IngredientCommand saveIngredientCommand(IngredientCommand command) {
        Optional<Recipe> recipeOptional = repo.findById(command.getRecipeId());

        if(!recipeOptional.isPresent()){

            //todo toss error if not found!
            log.error("Recipe not found for id: " + command.getRecipeId());
            return new IngredientCommand();
        } else {
            Recipe recipe = recipeOptional.get();

            Optional<Ingredient> ingredientOptional = recipe
                    .getIngredients()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(command.getId()))
                    .findFirst();

            if(ingredientOptional.isPresent()){
                Ingredient ingredientFound = ingredientOptional.get();
                ingredientFound.setDescription(command.getDescription());
                ingredientFound.setAmount(command.getAmount());
                ingredientFound.setUom(unitOfMeasureRepository
                        .findById(command.getUom().getId())
                        .orElseThrow(() -> new RuntimeException("UOM NOT FOUND"))); //todo address this
            } else {
                //add new Ingredient
            	Ingredient ingredient = ingredientCommandToIngredient.convert(command);
            	ingredient.setRecipe(recipe);
                recipe.addIngredient(ingredientCommandToIngredient.convert(command));
            }

            Recipe savedRecipe = repo.save(recipe);
            
            Optional<Ingredient> savedIngredientOptional = savedRecipe.getIngredients().stream()
            		.filter(recipeIngredients -> recipeIngredients.getDescription().equals(command.getDescription()))
            		.filter(recipeingredient -> recipeingredient.getUom().getId().equals(command.getUom().getId()))
            		.filter(recipeingredient -> recipeingredient.getAmount().equals(command.getAmount()))
            		.findFirst();

            return this.command.convert(savedIngredientOptional.get());
        }

    }

	@Override
	public void deleteIngredient(Long recipeId, Long ingredientId) {
		Optional<Recipe> recipeOptional = repo.findById(recipeId);
		
		if(recipeOptional.isPresent()) {
			Recipe recipe = recipeOptional.get();
			
			Optional<Ingredient> optionalIngredient = recipe
					.getIngredients()
					.stream()
					.filter(ingredient -> ingredient.getId().equals(ingredientId))
					.findFirst();
			
			if(optionalIngredient.isPresent()) {
				Ingredient deleteIngredient = optionalIngredient.get();
				deleteIngredient.setRecipe(null);
				recipe.getIngredients().remove(optionalIngredient.get());
				repo.save(recipe);
			}
		}else {
			log.debug("recipe not found");
		}
	}
}
