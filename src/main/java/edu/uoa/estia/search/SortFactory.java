package edu.uoa.estia.search;

import edu.uoa.estia.domain.SortingAlgorithm;

public class SortFactory {

	public static Sort createSort(SortingAlgorithm algo){
		
		switch(algo.getName()){ 
		case "TOPSIS": 
			 return new TopsisSort(); 
		case "SAW": 
			 return new SAWSort();
		default: 
			 return new IdentitySort(); 
		}
	}
	
}
