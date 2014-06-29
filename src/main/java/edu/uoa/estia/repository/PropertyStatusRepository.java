package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uoa.estia.domain.PropertyStatus;

public interface PropertyStatusRepository extends JpaRepository<PropertyStatus, Integer> {

}
