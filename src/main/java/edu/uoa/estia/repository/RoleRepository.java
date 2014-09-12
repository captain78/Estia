package edu.uoa.estia.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uoa.estia.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findByType(String type);

}