package edu.uoa.estia.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RoleCodes.class)
public class RoleCodes_ {

    public static volatile SingularAttribute<RoleCodes, Integer> id;

    public static volatile SingularAttribute<RoleCodes_, String> type;

    public static volatile SetAttribute<RoleCodes, User> userViaUserroleByUserid;

}
