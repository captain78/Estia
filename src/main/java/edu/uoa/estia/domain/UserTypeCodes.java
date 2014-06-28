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
@Table (name="UserTypeCodes")

public class UserTypeCodes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id 
    @Column(name="id" ) 
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="userTypeSequence")
    @SequenceGenerator(name = "userTypeSequence", sequenceName="USERTYPE_id_seq", allocationSize=1)
    private Integer id;

    @Column(name="type"   , nullable=true , unique=false)
    private String type; 

    public UserTypeCodes() {
    }

    
    public Integer getId() {
        return id;
    }
	
    public void setId (Integer id) {
        this.id =  id;
    }
    
    public String getType() {
        return type;
    }
	
    public void setType (String type) {
        this.type =  type;
    }
}
