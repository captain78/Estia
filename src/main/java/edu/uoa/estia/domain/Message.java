package edu.uoa.estia.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="Message")

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @Column(name="id" ) 
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="messageSequence")
    @SequenceGenerator(name = "messageSequence", sequenceName="message_id_seq", allocationSize=1)
    private Integer id;

    @Column(name="read"   , nullable=true , unique=false)
    private Boolean read; 

    @Column(name="message"   , nullable=false , unique=false)
    private String message; 

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="propertyId", referencedColumnName = "id" , nullable=true , unique=false , insertable=true, updatable=true) 
    private Property property;  

    @Column(name="propertyId"  , nullable=true , unique=false, insertable=false, updatable=false)
    private Integer propertyId;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="userId", referencedColumnName = "id" , nullable=true , unique=false , insertable=true, updatable=true) 
    private User user;  

    @Column(name="userId"  , nullable=true , unique=false, insertable=false, updatable=false)
    private Integer userId;

    public Integer getId() {
        return id;
    }
	
    public void setId (Integer id) {
        this.id =  id;
    }
    
    public Boolean getRead() {
        return read;
    }
	
    public void setRead (Boolean read) {
        this.read =  read;
    }
	
    public String getMessage() {
        return message;
    }
	
    public void setMessage (String message) {
        this.message =  message;
    }
	
    public Property getProperty () {
    	return property;
    }
	
    public void setProperty (Property property) {
    	this.property = property;
    }

    public Integer getPropertyId() {
        return propertyId;
    }
	
    public void setPropertyId (Integer propertyId) {
        this.propertyId =  propertyId;
    }
	
    public User getUser () {
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
	
}
