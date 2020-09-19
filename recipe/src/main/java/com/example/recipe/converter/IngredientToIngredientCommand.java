package com.example.recipe.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.recipe.command.IngredientCommand;
import com.example.recipe.model.Ingredient;

import lombok.Synchronized;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand>{

	private final UnitOfMeasureToUnitOfMeasureCommand uomCommand;
	
	
	public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomCommand) {
		this.uomCommand = uomCommand;
	}


	@Nullable
	@Synchronized
	@Override
	public IngredientCommand convert(Ingredient source) {
		if(source == null)
			return null;
		
		IngredientCommand command = new IngredientCommand();
		command.setId(source.getId());
		command.setDescription(source.getDescription());
		command.setAmout(source.getAmount());
		command.setUom(uomCommand.convert(source.getUom()));
		
		return command;
		
	}

}
