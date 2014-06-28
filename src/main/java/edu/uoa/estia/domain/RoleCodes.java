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
import javax.persistence.Table;

@Entity
@Table (name="RoleCodes")

public class RoleCodes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @Column(name="id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="type"   , nullable=false , unique=false)
    private String type; 
    @ManyToMany
    @JoinTable(name="USERROLE", 
        joinColumns=@JoinColumn(name="roleId"), 
        inverseJoinColumns=@JoinColumn(name="userId") 
    )
    private Set <User> userViaUserroleByUserid = new HashSet <User> ();

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
	
    public Set<User> getUserViaUserroleByUserid() {
        if (userViaUserroleByUserid == null){
            userViaUserroleByUserid = new HashSet<User>();
        }
        return userViaUserroleByUserid;
    }

    public void setUserViaUserroleByUserid (Set<User> userViaUserroleByUserid) {
        this.userViaUserroleByUserid = userViaUserroleByUserid;
    }
    	
    public void addUserViaUserroleByUserid (User element) {
        getUserViaUserroleByUserid().add(element);
    }
}
