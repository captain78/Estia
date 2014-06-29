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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table (name="Users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @Column(name="id" ) 
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="userSequence")
    @SequenceGenerator(name = "userSequence", sequenceName="ES_USERS_ID_seq", allocationSize=1)
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

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="type", referencedColumnName = "id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private UserType type;  

    @Column(name="type"  , nullable=false , unique=false, insertable=false, updatable=false)
    private java.lang.Integer type_; 

    @OneToMany (targetEntity=edu.uoa.estia.domain.Message.class, fetch=FetchType.LAZY, mappedBy="userid", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Message> messageUserViaUserId = new HashSet<Message>(); 

    @OneToMany (targetEntity=edu.uoa.estia.domain.Property.class, fetch=FetchType.LAZY, mappedBy="userid", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Property> propertyUserViaUserId = new HashSet<Property>(); 

    @ManyToMany
    @JoinTable(name="USERROLE", 
        joinColumns=@JoinColumn(name="userId"), 
        inverseJoinColumns=@JoinColumn(name="roleId") 
    )
    private Set <Role> roleViaUserRoleByRoleId = new HashSet <Role> ();

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
    
    public UserType getType() {
        return type;
    }
	
    public void setType (UserType type) {
        this.type =  type;
    }
	
    public java.lang.Integer getType_() {
        return type_;
    }
	
    public void setType_ (java.lang.Integer type_) {
        this.type_ =  type_;
    }
	
    public Set<Message> getMessageUserViaUserId() {
        if (messageUserViaUserId == null){
        	messageUserViaUserId = new HashSet<Message>();
        }
        return messageUserViaUserId;
    }

    public void setMessageUserViaUserId (Set<Message> messageUserViaUserId) {
        this.messageUserViaUserId = messageUserViaUserId;
    }	
    
    public void addMessageUserViaUserid (Message element) {
    	    getMessageUserViaUserId().add(element);
    }
    
    public Set<Property> getPropertyUserViaUserId() {
        if (propertyUserViaUserId == null){
        	propertyUserViaUserId = new HashSet<Property>();
        }
        return propertyUserViaUserId;
    }

    public void setPropertyUserViaUserId (Set<Property> propertyUserViaUserId) {
        this.propertyUserViaUserId = propertyUserViaUserId;
    }	
    
    public void addPropertyUserViaUserid (Property element) {
    	    getPropertyUserViaUserId().add(element);
    }
    
    public Set<Role> getRoleViaUserRoleByRoleId() {
        if (roleViaUserRoleByRoleId == null){
        	roleViaUserRoleByRoleId = new HashSet<Role>();
        }
        return roleViaUserRoleByRoleId;
    }

    public void setRoleViaUserRoleByRoleId (Set<Role> roleViaUserRoleByRoleId) {
        this.roleViaUserRoleByRoleId = roleViaUserRoleByRoleId;
    }
    	
    public void addRoleViaUserRoleByRoleId (Role element) {
    	getRoleViaUserRoleByRoleId().add(element);
    }
	
}
