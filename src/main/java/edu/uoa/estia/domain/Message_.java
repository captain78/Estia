package edu.uoa.estia.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Message.class)
public class Message_ {

    public static volatile SingularAttribute<Message, Integer> id;

    public static volatile SingularAttribute<Message, Boolean> read;
    public static volatile SingularAttribute<Message, String> message;


    public static volatile SingularAttribute<Message, Property> property;
    public static volatile SingularAttribute<Message, Integer> propertyId;

    public static volatile SingularAttribute<Message, User> user;
    public static volatile SingularAttribute<Message, Integer> userId;
}
