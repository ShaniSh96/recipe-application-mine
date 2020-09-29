package com.example.recipe.service;

import java.util.Set;

import com.example.recipe.command.UnitOfMeasureCommand;

public interface UnitOfMeasureService {

	Set<UnitOfMeasureCommand> listAllUoms();
}
