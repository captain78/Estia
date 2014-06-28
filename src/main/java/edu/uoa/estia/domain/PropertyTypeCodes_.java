package edu.uoa.estia.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PropertyTypeCodes.class)
public class PropertyTypeCodes_ {

    public static volatile SingularAttribute<PropertyTypeCodes, Integer> id;

    public static volatile SingularAttribute<PropertyTypeCodes, String> type;

    public static volatile SetAttribute<PropertyTypeCodes, Property> propertyPropertytypecodesViaType;


}
