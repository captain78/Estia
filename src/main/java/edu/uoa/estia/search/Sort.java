package edu.uoa.estia.search;

import java.util.List;

import edu.uoa.estia.domain.Property;

public interface Sort {

	public List<Property> sort(List<Property> properties, List<SortWeight<String,Long>> weigths);
	
}
