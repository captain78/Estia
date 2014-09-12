package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uoa.estia.domain.SortingAlgorithm;

@Repository
public interface SortingAlgorithmRepository extends JpaRepository<SortingAlgorithm, Integer> {

}