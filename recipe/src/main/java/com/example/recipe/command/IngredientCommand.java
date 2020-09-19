package com.example.recipe.command;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
	private Long id;
	private String description;
	private UnitOfMeasureCommand uom;
	private BigDecimal amout;
}
