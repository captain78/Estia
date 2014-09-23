package edu.uoa.estia.domain;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.vividsolutions.jts.geom.Point;


@StaticMetamodel(Property.class)
public class Property_ {

    public static volatile SingularAttribute<Property, Integer> id;
    public static volatile SingularAttribute<Property, PropertyType> type;
    public static volatile SingularAttribute<Property, Integer> type_;
    public static volatile SingularAttribute<Property, User> user;
    public static volatile SingularAttribute<Property, Integer> userId;
    public static volatile SingularAttribute<Property, Point> topothesia;
    public static volatile SingularAttribute<Property, String> dieythinsi;    
    public static volatile SingularAttribute<Property, Boolean>  centralheating;
    public static volatile SingularAttribute<Property, Integer> constructionyear;
    public static volatile SingularAttribute<Property, Integer> renovationyear;
    public static volatile SingularAttribute<Property, Double> koinoxrista;
    public static volatile SingularAttribute<Property, Float> emvadon;
    public static volatile SingularAttribute<Property, Integer> orofos;
    public static volatile SingularAttribute<Property, Double> price;
    public static volatile SetAttribute<Property, Message> messages;
    public static volatile SetAttribute<Property, PropertyStatus> propertyStatus;
    public static volatile ListAttribute<Property, PropertyImage> propertyimages;
}