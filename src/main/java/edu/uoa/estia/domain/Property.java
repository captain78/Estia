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
@Table (name="Property")

public class Property implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @Column(name="id" ) 
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="propertySequence")
    @SequenceGenerator(name = "propertySequence", sequenceName="Property_id_seq", allocationSize=1)
    private Integer id;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="type", referencedColumnName = "id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private PropertyType type;  

    @Column(name="type"  , nullable=false , unique=false, insertable=false, updatable=false)
    private Integer type_;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="userId", referencedColumnName = "id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private User user;  

    @Column(name="userId"  , nullable=false , unique=false, insertable=false, updatable=false)
    private Integer userId;

    @OneToMany (targetEntity=edu.uoa.estia.domain.Message.class, fetch=FetchType.LAZY, mappedBy="property", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Message> messages = new HashSet<Message>(); 
    
    @ManyToMany
    @JoinTable(name="PROPERTYSTATUS", 
        joinColumns=@JoinColumn(name="propertyId"), 
        inverseJoinColumns=@JoinColumn(name="propertyStatus") 
    )
    private Set <PropertyStatus> propertyStatus = new HashSet <PropertyStatus> ();    

    public Integer getId() {
        return id;
    }
	
    public void setId (Integer id) {
        this.id =  id;
    }
    

    public PropertyType getType () {
    	return type;
    }
	
    public void setType (PropertyType type) {
    	this.type = type;
    }

    public Integer getType_() {
        return type_;
    }
	
    public void setType_ (Integer type) {
        this.type_ =  type;
    }
	
    public User getUser() {
    	return user;
    }
	
    public void setUser (User user) {
    	this.user = user;
    }

    public Integer getUserId() {
        return userId;
    }
	
    public void setUserId (Integer userId) {
        this.userId =  userId;
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
    
}