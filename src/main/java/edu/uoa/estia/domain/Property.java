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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="Property")

public class Property implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @Column(name="id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="type", referencedColumnName = "id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private PropertyType type;  

    @Column(name="type"  , nullable=false , unique=false, insertable=false, updatable=false)
    private Integer type_;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="userId", referencedColumnName = "id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private User userid;  

    @Column(name="userId"  , nullable=false , unique=false, insertable=false, updatable=false)
    private Integer userid_;

    @OneToMany (targetEntity=edu.uoa.estia.domain.Message.class, fetch=FetchType.LAZY, mappedBy="propertyid", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Message> messagePropertyViaPropertyid = new HashSet<Message>(); 

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
	
    public Set<Message> getMessagePropertyViaPropertyid() {
        if (messagePropertyViaPropertyid == null){
            messagePropertyViaPropertyid = new HashSet<Message>();
        }
        return messagePropertyViaPropertyid;
    }

    public void setMessagePropertyViaPropertyid (Set<Message> messagePropertyViaPropertyid) {
        this.messagePropertyViaPropertyid = messagePropertyViaPropertyid;
    }	
    
    public void addMessagePropertyViaPropertyid (Message element) {
    	    getMessagePropertyViaPropertyid().add(element);
    }
    
}
