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
@Table (name="UserTypeCodes")

public class UserType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id 
    @Column(name="id" ) 
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="userTypeSequence")
    @SequenceGenerator(name = "userTypeSequence", sequenceName="USERTYPE_id_seq", allocationSize=1)
    private Integer id;

    @Column(name="type"   , nullable=true , unique=false)
    private String type; 

    @OneToMany (targetEntity=edu.uoa.estia.domain.User.class, fetch=FetchType.LAZY, mappedBy="type", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <User> userUserTypeViaType = new HashSet<User>(); 
    
    public UserType() {
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
    
    public Set<User> getUserUserTypeViaType() {
        if (userUserTypeViaType == null){
        	userUserTypeViaType = new HashSet<User>();
        }
        return userUserTypeViaType;
    }

    public void setUserUserTypeViaType(Set<User> userUserTypeViaType) {
        this.userUserTypeViaType = userUserTypeViaType;
    }	
    
    public void addUserUserTypeViaType(User element) {
    	getUserUserTypeViaType().add(element);
    }    
}
