package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uoa.estia.domain.Mytable;

@Repository
public interface MytableRepository extends JpaRepository<Mytable, Integer>{

     Mytable findByMytext(String mytext);
     
}
