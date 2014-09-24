package edu.uoa.estia.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uoa.estia.domain.Property;

@Service
@Transactional(readOnly=true) // Make Service transactional and read-only
public interface SearchService {

	// And specialise with a timeout of 5 seconds
	@Transactional(timeout=5)
	public List<Property> findAll();
	
	@Transactional(timeout=5)
	public List<Property> findAll(int rooms, boolean centralHeating, boolean hasGaraze, String algo);
	
	
}
