package edu.uoa.estia.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PropertyStatusCodes.class)
public class PropertyStatusCodes_ {

    public static volatile SingularAttribute<PropertyStatusCodes, Integer> id;

    public static volatile SingularAttribute<PropertyStatusCodes, String> status;


}
