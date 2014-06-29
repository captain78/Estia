package edu.uoa.estia.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Property.class)
public class Property_ {

    public static volatile SingularAttribute<Property, Integer> id;

    public static volatile SingularAttribute<Property, PropertyType> type;
    public static volatile SingularAttribute<Property, Integer> type_;

    public static volatile SingularAttribute<Property, User> userid;
    public static volatile SingularAttribute<Property, Integer> userid_;

    public static volatile SetAttribute<Property, Message> messagePropertyViaPropertyid;
}
