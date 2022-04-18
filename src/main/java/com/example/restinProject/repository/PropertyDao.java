package com.example.restinProject.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.restinProject.entity.Property;

public interface PropertyDao extends MongoRepository<Property, String> {
	@Query(value= "SELECT p FROM Property p WHERE p.bestSeller = true")
    List<Property> findByBestSeller();
}
