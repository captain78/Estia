package edu.uoa.estia.search;

import java.util.List;

import edu.uoa.estia.domain.Property;

public class IdentitySort implements Sort {

	@Override
	public List<Property> sort(List<Property> properties, List<SortWeight<String,Long>> weights) {
		return properties;
	}

}
