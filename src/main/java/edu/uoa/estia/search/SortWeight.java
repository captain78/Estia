package edu.uoa.estia.search;

public class SortWeight<A,V> {
    
	private A attribute;
	private V value;
	
	public SortWeight(A attr, V val){
		attribute = attr;
		value = val;
	}
	
	public A getAttribute(){
		return attribute;
	}
	
	public V getValue(){
		return value;
	}
}
