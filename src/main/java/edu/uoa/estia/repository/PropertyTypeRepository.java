package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uoa.estia.domain.PropertyType;

public interface PropertyTypeRepository extends JpaRepository<PropertyType, Integer> {

}
