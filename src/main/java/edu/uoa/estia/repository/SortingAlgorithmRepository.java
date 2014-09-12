package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uoa.estia.domain.SortingAlgorithm;

public interface SortingAlgorithmRepository extends JpaRepository<SortingAlgorithm, Integer> {

}