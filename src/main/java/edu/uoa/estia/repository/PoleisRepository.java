package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uoa.estia.domain.Polei;

@Repository
public interface PoleisRepository extends JpaRepository<Polei, Integer>{

		Polei findByName(String name);
		
		Polei findByOnoma(String onoma);
		
}
