package com.example.recipe.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.recipe.command.IngredientCommand;
import com.example.recipe.model.Ingredient;
import com.example.recipe.model.Recipe;

import lombok.Synchronized;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient>{

	
	private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;
	public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
		this.uomConverter = uomConverter;
	}


	@Nullable
	@Override
	public Ingredient convert(IngredientCommand source) {
		if(source == null)
			return null;
		
		final Ingredient ingredient = new Ingredient();

		if(source.getRecipeId() != null){
            Recipe recipe = new Recipe();
            recipe.setId(source.getRecipeId());
            ingredient.setRecipe(recipe);
            recipe.addIngredient(ingredient);
        }

        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUom(uomConverter.convert(source.getUom()));
        return ingredient;
	}

}
