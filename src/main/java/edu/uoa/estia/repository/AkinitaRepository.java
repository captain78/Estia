package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uoa.estia.domain.Akinita;

@Repository
public interface AkinitaRepository extends JpaRepository<Akinita, Integer>{

	Akinita findByIdioktitis(String idioktitis);
	
}
