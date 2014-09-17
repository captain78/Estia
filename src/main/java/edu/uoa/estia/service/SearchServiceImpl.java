package edu.uoa.estia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uoa.estia.domain.Akinita;
import edu.uoa.estia.repository.AkinitaRepository;

@Component("SearchServiceImpl")
public class SearchServiceImpl implements SearchService {

	final AkinitaRepository propertyRepo;
	
    @Autowired
	public SearchServiceImpl(final AkinitaRepository propertyRepo){
		this.propertyRepo = propertyRepo;
	}
    
	@Override
	public List<Akinita> findAll() {
		return propertyRepo.findAll();
	}

	@Override
	public List<Akinita> findAll(int rooms, boolean centralHeating,
			boolean hasGaraze, String algo) {
		// TODO Auto-generated method stub
		return null;
	}

}
