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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name="Users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @Column(name="id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="username"   , nullable=false , unique=false)
    private String username; 

    @Column(name="firstName"   , nullable=true , unique=false)
    private String firstName; 

    @Column(name="lastName"   , nullable=false , unique=false)
    private String lastName; 

    @Column(name="email"   , nullable=false , unique=false)
    private String email; 

    @Column(name="telephone"   , nullable=false , unique=false)
    private String telephone; 

    @Column(name="password"   , nullable=true , unique=false)
    private String password; 

    @Column(name="type"   , nullable=false , unique=false)
    private java.lang.Integer type; 

    @OneToMany (targetEntity=edu.uoa.estia.domain.Message.class, fetch=FetchType.LAZY, mappedBy="userid", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Message> messageUserViaUserid = new HashSet<Message>(); 

    @OneToMany (targetEntity=edu.uoa.estia.domain.Property.class, fetch=FetchType.LAZY, mappedBy="userid", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Property> propertyUserViaUserid = new HashSet<Property>(); 

    @ManyToMany
    @JoinTable(name="USERROLE", 
        joinColumns=@JoinColumn(name="userId"), 
        inverseJoinColumns=@JoinColumn(name="roleId") 
    )
    private Set <RoleCodes> rolecodesViaUserroleByRoleid = new HashSet <RoleCodes> ();

    public Integer getId() {
        return id;
    }
	
    public void setId (Integer id) {
        this.id =  id;
    }
    
    public String getUsername() {
        return username;
    }
	
    public void setUsername (String username) {
        this.username =  username;
    }
	
    public String getFirstName() {
        return firstName;
    }
	
    public void setFirstName (String firstName) {
        this.firstName =  firstName;
    }

    public String getLastName() {
        return lastName;
    }
	
    public void setLastName (String lastName) {
        this.lastName =  lastName;
    }
	
    public String getEmail() {
        return email;
    }
	
    public void setEmail (String email) {
        this.email =  email;
    }
	
    public String getTelephone() {
        return telephone;
    }
	
    public void setTelephone (String telephone) {
        this.telephone =  telephone;
    }
	
    public String getPassword() {
        return password;
    }
	
    public void setPassword (String password) {
        this.password =  password;
    }
	
    public java.lang.Integer getType() {
        return type;
    }
	
    public void setType (java.lang.Integer type) {
        this.type =  type;
    }
	
    public Set<Message> getMessageUserViaUserid() {
        if (messageUserViaUserid == null){
            messageUserViaUserid = new HashSet<Message>();
        }
        return messageUserViaUserid;
    }

    public void setMessageUserViaUserid (Set<Message> messageUserViaUserid) {
        this.messageUserViaUserid = messageUserViaUserid;
    }	
    
    public void addMessageUserViaUserid (Message element) {
    	    getMessageUserViaUserid().add(element);
    }
    
    public Set<Property> getPropertyUserViaUserid() {
        if (propertyUserViaUserid == null){
            propertyUserViaUserid = new HashSet<Property>();
        }
        return propertyUserViaUserid;
    }

    public void setPropertyUserViaUserid (Set<Property> propertyUserViaUserid) {
        this.propertyUserViaUserid = propertyUserViaUserid;
    }	
    
    public void addPropertyUserViaUserid (Property element) {
    	    getPropertyUserViaUserid().add(element);
    }
    
    public Set<RoleCodes> getRolecodesViaUserroleByRoleid() {
        if (rolecodesViaUserroleByRoleid == null){
            rolecodesViaUserroleByRoleid = new HashSet<RoleCodes>();
        }
        return rolecodesViaUserroleByRoleid;
    }

    public void setRolecodesViaUserroleByRoleid (Set<RoleCodes> rolecodesViaUserroleByRoleid) {
        this.rolecodesViaUserroleByRoleid = rolecodesViaUserroleByRoleid;
    }
    	
    public void addRolecodesViaUserroleByRoleid (RoleCodes element) {
        getRolecodesViaUserroleByRoleid().add(element);
    }
	
}
