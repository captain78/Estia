package edu.uoa.estia.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(UserType.class)
public class UserType_ {

    public static volatile SingularAttribute<UserType, Integer> id;

    public static volatile SingularAttribute<UserType, String> type;
    
    public static volatile SetAttribute<UserType, User> userUserTypeViaType;

}
