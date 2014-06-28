package edu.uoa.estia.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Message.class)
public class Message_ {

    public static volatile SingularAttribute<Message, Integer> id;

    public static volatile SingularAttribute<Message, Boolean> read;
    public static volatile SingularAttribute<Message, String> message;


    public static volatile SingularAttribute<Message, Property> propertyid;
    public static volatile SingularAttribute<Message, Integer> propertyid_;

    public static volatile SingularAttribute<Message, User> userid;
    public static volatile SingularAttribute<Message, Integer> userid_;
}
