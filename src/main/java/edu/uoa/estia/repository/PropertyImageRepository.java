package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uoa.estia.domain.PropertyImage;

@Repository
public interface PropertyImageRepository extends JpaRepository<PropertyImage, Integer>{

}
