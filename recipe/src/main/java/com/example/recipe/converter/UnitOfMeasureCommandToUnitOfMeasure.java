package com.example.recipe.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.recipe.command.UnitOfMeasureCommand;
import com.example.recipe.model.UnitOfMeasure;

import lombok.Synchronized;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure>{

	@Override
	public UnitOfMeasure convert(UnitOfMeasureCommand source) {
		if(source == null)
			return null;
		
		final UnitOfMeasure uom = new UnitOfMeasure();
		uom.setId(source.getId());
		uom.setUom(source.getUom());
		return uom;
	}

	

	
}
