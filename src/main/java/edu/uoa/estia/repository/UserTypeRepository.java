package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uoa.estia.domain.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
	
	UserType findByType(String type);

}