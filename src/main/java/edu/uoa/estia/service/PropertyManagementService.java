package edu.uoa.estia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uoa.estia.domain.Property;

@Service
public interface PropertyManagementService {

	public List<Property> findAll();
	
}
