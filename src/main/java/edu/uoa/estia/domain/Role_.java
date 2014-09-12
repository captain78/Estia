package edu.uoa.estia.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Role.class)
public class Role_ {

    public static volatile SingularAttribute<Role, Integer> id;

    public static volatile SingularAttribute<Role, String> type;

    public static volatile SetAttribute<Role, User> users;

}