package edu.uoa.estia.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="RoleCodes")

public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @Column(name="id" ) 
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="roleSequence")
    @SequenceGenerator(name = "roleSequence", sequenceName="ES_ROLES_ID_seq", allocationSize=1)
    private Integer id;

    @Column(name="type"   , nullable=false , unique=false)
    private String type; 
    
    @ManyToMany
    @JoinTable(name="USERROLE", 
        joinColumns=@JoinColumn(name="roleId"), 
        inverseJoinColumns=@JoinColumn(name="userId") 
    )
    private Set <User> users = new HashSet <User> ();

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
	
    public Set<User> getUsers() {
        if (users == null){
        	users = new HashSet<User>();
        }
        return users;
    }

    public void setUsers (Set<User> users) {
        this.users = users;
    }
    	
    public void addUser (User element) {
    	getUsers().add(element);
    }
}
