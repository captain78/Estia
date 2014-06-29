package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uoa.estia.domain.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
	
	UserType findByType(String type);

}
