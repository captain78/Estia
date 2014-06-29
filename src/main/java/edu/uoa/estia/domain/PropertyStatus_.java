package edu.uoa.estia.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PropertyStatus.class)
public class PropertyStatus_ {

    public static volatile SingularAttribute<PropertyStatus, Integer> id;

    public static volatile SingularAttribute<PropertyStatus, String> status;


}
