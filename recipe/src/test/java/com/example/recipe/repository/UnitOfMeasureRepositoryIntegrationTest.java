package com.example.recipe.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.recipe.repository.*;

import com.example.recipe.model.UnitOfMeasure;


//@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepositoryIntegrationTest {

	@Autowired
	UnitOfMeasureRepository repo;
	
	@BeforeEach
	void setUp() {
		
	}
	
	@Test
	void testFindByUom() {
		Optional<UnitOfMeasure> uom = repo.findByUom("TeasSpoon");
		assertEquals("TeasSpoon",uom.get().getUom());
	}

}
