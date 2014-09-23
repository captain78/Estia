package edu.uoa.estia.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(SortingAlgorithm.class)
public class SortingAlgorithm_ {

    public static volatile SingularAttribute<SortingAlgorithm, Integer> id;
    
    public static volatile SingularAttribute<SortingAlgorithm, String> name;

    public static volatile SingularAttribute<SortingAlgorithm, String> description;

}
