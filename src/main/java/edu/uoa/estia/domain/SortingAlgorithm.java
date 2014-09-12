package edu.uoa.estia.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="SortingAlgorithmsCodes")

public class SortingAlgorithm implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @Column(name="id" ) 
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="sortingSequence")
    @SequenceGenerator(name = "sortingSequence", sequenceName="sortingAlgorithms_id_seq", allocationSize=1)
    private Integer id;

    @Column(name="description"   , nullable=false , unique=false)
    private String description; 

    public Integer getId() {
        return id;
    }
	
    public void setId (Integer id) {
        this.id =  id;
    }
    
    public String getDescription() {
        return description;
    }
	
    public void setDescription (String description) {
        this.description =  description;
    }
	
}