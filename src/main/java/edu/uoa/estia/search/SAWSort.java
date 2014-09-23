package edu.uoa.estia.search;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.uoa.estia.domain.Property;

public class SAWSort implements Sort {
	
	@Override
	public List<Property> sort(List<Property> properties, List<SortWeight<String,Long>> weights) {
		 Collections.sort(properties, new SAWComparator(weights));
		 return properties;
	}
	
	private class SAWComparator implements Comparator<Property>{
		
		List<SortWeight<String,Long>> weigths;
		
		public SAWComparator(List<SortWeight<String,Long>> weigths){
			this.weigths = weigths;
		}

		@Override
		public int compare(Property p1, Property p2) {
			return (int)(getScore(p1,weigths)-getScore(p2,weigths));
		}
		
		private long getScore(Property p, List<SortWeight<String,Long>> weigths){
			// do the actual calculation here
			
			return 0;
		}
		
	}


}
