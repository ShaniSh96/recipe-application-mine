package com.example.recipe.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.recipe.model.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{

	Optional<UnitOfMeasure> findByUom(String uom);
	
}
