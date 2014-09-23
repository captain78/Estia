package edu.uoa.estia.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PropertyImage.class)
public class PropertyImage_ {

	 public static volatile SingularAttribute<PropertyImage, Integer> id;
	 public static volatile SingularAttribute<PropertyImage, String> imagePath;
	 public static volatile SingularAttribute<PropertyImage, Property> property;
	 
}
