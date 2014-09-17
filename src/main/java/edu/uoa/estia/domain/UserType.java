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

    /* This seems to lead to out.ofmemory loops
    @OneToMany (targetEntity=edu.uoa.estia.domain.User.class, fetch=FetchType.LAZY, mappedBy="type", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <User> users = new HashSet<User>(); 
    */
    
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
    
    /*
    
    public Set<User> getUsers() {
        if (users == null){
        	users = new HashSet<User>();
        }
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }	
    
    public void addUser(User element) {
    	getUsers().add(element);
    } 
    */   
}