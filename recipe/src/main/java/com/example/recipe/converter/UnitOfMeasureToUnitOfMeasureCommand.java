package com.example.recipe.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.recipe.command.UnitOfMeasureCommand;
import com.example.recipe.model.UnitOfMeasure;

import lombok.Synchronized;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand  implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

	 	@Synchronized
	    @Nullable
	    @Override
	    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {

	        if (unitOfMeasure != null) {
	            final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
	            uomc.setId(unitOfMeasure.getId());
	            uomc.setUom(unitOfMeasure.getUom());
	            return uomc;
	        }
	        return null;
	    }
}
