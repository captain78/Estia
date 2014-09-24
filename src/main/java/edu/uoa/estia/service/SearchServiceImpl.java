package edu.uoa.estia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uoa.estia.domain.Property;
import edu.uoa.estia.repository.PropertyRepository;

@Component("SearchServiceImpl")
public class SearchServiceImpl implements SearchService {

	final PropertyRepository propertyRepo;
	
    @Autowired
	public SearchServiceImpl(final PropertyRepository propertyRepo){
		this.propertyRepo = propertyRepo;
	}
    
	@Override
	public List<Property> findAll() {
		return propertyRepo.findAll();
	}

	@Override
	public List<Property> findAll(int rooms, boolean centralHeating,
			boolean hasGaraze, String algo) {
		// TODO Auto-generated method stub
		return null;
	}

}
