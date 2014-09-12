package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uoa.estia.domain.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {


}