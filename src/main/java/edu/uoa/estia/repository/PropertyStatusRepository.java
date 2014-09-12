package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uoa.estia.domain.PropertyStatus;

@Repository
public interface PropertyStatusRepository extends JpaRepository<PropertyStatus, Integer> {

}