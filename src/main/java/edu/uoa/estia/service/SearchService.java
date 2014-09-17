package edu.uoa.estia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uoa.estia.domain.Akinita;

@Service
public interface SearchService {

	public List<Akinita> findAll();
	
	public List<Akinita> findAll(int rooms, boolean centralHeating, boolean hasGaraze, String algo);
	
}
