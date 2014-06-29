package edu.uoa.estia.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
public class User_ {

    public static volatile SingularAttribute<User, Integer> id;

    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> telephone;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, java.lang.Integer> type_;
    public static volatile SingularAttribute<User, UserType> type;
    
    
    public static volatile SetAttribute<User, Message> messageUserViaUserId;
    public static volatile SetAttribute<User, Property> propertyUserViaUserId;

    public static volatile SetAttribute<User, Role> roleViaUserRoleByRoleId;

}
