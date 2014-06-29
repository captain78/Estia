package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uoa.estia.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findByType(String type);

}
