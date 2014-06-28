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
    private Property propertyid;  

    @Column(name="propertyId"  , nullable=true , unique=false, insertable=false, updatable=false)
    private Integer propertyid_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="userId", referencedColumnName = "id" , nullable=true , unique=false , insertable=true, updatable=true) 
    private User userid;  

    @Column(name="userId"  , nullable=true , unique=false, insertable=false, updatable=false)
    private Integer userid_;

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
	
    public Property getPropertyid () {
    	return propertyid;
    }
	
    public void setPropertyid (Property propertyid) {
    	this.propertyid = propertyid;
    }

    public Integer getPropertyid_() {
        return propertyid_;
    }
	
    public void setPropertyid_ (Integer propertyid) {
        this.propertyid_ =  propertyid;
    }
	
    public User getUserid () {
    	return userid;
    }
	
    public void setUserid (User userid) {
    	this.userid = userid;
    }

    public Integer getUserid_() {
        return userid_;
    }
	
    public void setUserid_ (Integer userid) {
        this.userid_ =  userid;
    }
	
}
