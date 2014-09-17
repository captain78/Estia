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

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table (name="Users")
public class User implements Serializable {
   
	private static final long serialVersionUID = 1L;

    @Id @Column(name="id" ) 
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="userSequence")
    @SequenceGenerator(name = "userSequence", sequenceName="es_users_id_seq", allocationSize=1)
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

    @JsonIgnore
    @Column(name="password"   , nullable=true , unique=false)
    private String password; 

    @ManyToOne (fetch=FetchType.EAGER , optional=false)
    @JoinColumn(name="type", referencedColumnName = "id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private UserType type;  

    @Column(name="type"  , nullable=false , unique=false, insertable=false, updatable=false)
    private java.lang.Integer type_; 

    @JsonIgnore
    @OneToMany (targetEntity=edu.uoa.estia.domain.Message.class, fetch=FetchType.LAZY, mappedBy="user", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Message> messages = new HashSet<Message>(); 

    @JsonIgnore
    @OneToMany (targetEntity=edu.uoa.estia.domain.Property.class, fetch=FetchType.LAZY, mappedBy="userId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Property> properties = new HashSet<Property>(); 

    @JsonIgnore
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="USERROLE", 
        joinColumns=@JoinColumn(name="userId"), 
        inverseJoinColumns=@JoinColumn(name="roleId") 
    )
    private Set<Role> roles = new HashSet<Role>();
    
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
	
    public Set<Message> getMessages() {
        if (messages == null){
        	messages = new HashSet<Message>();
        }
        return messages;
    }

    public void setMessages (Set<Message> messages) {
        this.messages = messages;
    }	
    
    public void addMessage (Message element) {
    	getMessages().add(element);
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
    
    public void addProperty(Property element) {
    	getProperties().add(element);
    }
    
    public Set<Role> getRoles() {
        if (roles == null){
        	roles = new HashSet<Role>();
        }
        return roles;
    }

    public void setRoles (Set<Role> roles) {
        this.roles = roles;
    }
    	
    public void addRole(Role element) {
    	getRoles().add(element);
    }
	
}