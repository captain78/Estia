package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uoa.estia.domain.PropertyType;

@Repository
public interface PropertyTypeRepository extends JpaRepository<PropertyType, Integer> {
	
	PropertyType findByType(String type);

}