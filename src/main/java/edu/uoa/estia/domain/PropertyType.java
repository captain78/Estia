package edu.uoa.estia.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table (name="PropertyTypeCodes")

public class PropertyType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id 
    @Column(name="id" ) 
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="propertyTypeSequence")
    @SequenceGenerator(name = "propertyTypeSequence", sequenceName="PropertyType_id_seq", allocationSize=1)
    private Integer id;

    @Column(name="type"   , nullable=true , unique=false)
    private String type; 

    @OneToMany (targetEntity=edu.uoa.estia.domain.Property.class, fetch=FetchType.LAZY, mappedBy="type", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Property> properties = new HashSet<Property>(); 

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
	
    public Set<Property> getProperties() {
        if (properties == null){
        	properties = new HashSet<Property>();
        }
        return properties;
    }

    public void setProperties (Set<Property> properties) {
        this.properties = properties;
    }	
    
    public void addProperty (Property element) {
    	getProperties().add(element);
    }
}
