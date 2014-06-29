package edu.uoa.estia.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PropertyType.class)
public class PropertyType_ {

    public static volatile SingularAttribute<PropertyType, Integer> id;

    public static volatile SingularAttribute<PropertyType, String> type;

    public static volatile SetAttribute<PropertyType, Property> properties;


}
