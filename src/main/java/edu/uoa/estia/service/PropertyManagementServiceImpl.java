package edu.uoa.estia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uoa.estia.domain.Property;
import edu.uoa.estia.repository.PropertyRepository;

@Component("PropertyManagementServiceImpl")
public class PropertyManagementServiceImpl implements PropertyManagementService {

    final PropertyRepository propertyRepo;
	
    @Autowired
	public PropertyManagementServiceImpl(final PropertyRepository propertyRepo){
		this.propertyRepo = propertyRepo;
	}

	@Override
	public List<Property> findAll() {
		return propertyRepo.findAll();
	}
    
}
