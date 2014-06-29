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
@Table (name="PropertyStatusCodes")

public class PropertyStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @Column(name="id" ) 
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="propertyStatusSequence")
    @SequenceGenerator(name = "propertyStatusSequence", sequenceName="PropertyStatus_id_seq", allocationSize=1)
    private Integer id;

    @Column(name="status"   , nullable=false , unique=false)
    private String status; 

    public Integer getId() {
        return id;
    }
	
    public void setId (Integer id) {
        this.id =  id;
    }
    
    public String getStatus() {
        return status;
    }
	
    public void setStatus (String status) {
        this.status =  status;
    }
	
}
