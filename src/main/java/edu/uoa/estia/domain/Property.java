package edu.uoa.estia.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Point;

import edu.uoa.estia.utils.JTSGeomToGeoJSONDeserializer;
import edu.uoa.estia.utils.JTSGeomToGeoJSONSerializer;

@Entity
@Table (name="Property")
public class Property implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @Column(name="id" ) 
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="propertySequence")
    @SequenceGenerator(name = "propertySequence", sequenceName="Property_id_seq", allocationSize=1)
    private Integer id;

    @ManyToOne (fetch=FetchType.EAGER , optional=false)
    @JoinColumn(name="type", referencedColumnName = "id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private PropertyType type;  

    @Column(name="type"  , nullable=false , unique=false, insertable=false, updatable=false)
    private Integer type_;

    @ManyToOne (fetch=FetchType.EAGER , optional=false)
    @JoinColumn(name="userId", referencedColumnName = "id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private User user;  

    @Column(name="userId"  , nullable=false , unique=false, insertable=false, updatable=false)
    private Integer userId;

    @OneToMany (targetEntity=edu.uoa.estia.domain.Message.class, fetch=FetchType.EAGER, mappedBy="property", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Message> messages = new HashSet<Message>(); 
    
    @ManyToMany
    @JoinTable(name="PROPERTYSTATUS", 
        joinColumns=@JoinColumn(name="propertyId"), 
        inverseJoinColumns=@JoinColumn(name="propertyStatus") 
    )
    private Set <PropertyStatus> propertyStatus = new HashSet <PropertyStatus> ();    

	//bi-directional many-to-one association to Propertyimage
	@OneToMany(mappedBy="property", fetch=FetchType.EAGER)
	private List<PropertyImage> propertyimages;
    
    @JsonIgnore
	@Column(columnDefinition="Geometry", name="topothesia")
	@Type(type="org.hibernate.spatial.GeometryType")
	private Point topothesia;

    @Column(name="dieythinsi")
	private String dieythinsi;
    
    @Column(name="centralheating", nullable=false)
	private Boolean centralheating;
	
    @Column(name="constructionyear", nullable=false)
    private Integer constructionyear;
    
    @Column(name="emvadon", nullable=false)
	private Float emvadon;
    
    @Column(name="koinoxrista")
	private Double koinoxrista;
    
    @Column(name="orofos", nullable=false)
	private Integer orofos;
    
    @Column(name="price", nullable=false)
	private Double price;
    
    @Column(name="renovationyear", nullable=false)
	private Integer renovationyear;
	
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
    
	public String getDieythinsi() {
		return this.dieythinsi;
	}

	public void setDieythinsi(String dieythinsi) {
		this.dieythinsi = dieythinsi;
	}
	
	public Boolean getCentralHeating() {
		return this.centralheating;
	}

	public void setCentralHeating(Boolean centralheating) {
		this.centralheating = centralheating;
	}

	public Integer getConstructionYear() {
		return this.constructionyear;
	}

	public void setConstructionYear(Integer constructionyear) {
		this.constructionyear = constructionyear;
	}
	
	public float getEmvadon() {
		return this.emvadon;
	}

	public void setEmvadon(Float emvadon) {
		this.emvadon = emvadon;
	}


	public double getKoinoxrista() {
		return this.koinoxrista;
	}

	public void setKoinoxrista(Double koinoxrista) {
		this.koinoxrista = koinoxrista;
	}

	public Integer getOrofos() {
		return this.orofos;
	}

	public void setOrofos(Integer orofos) {
		this.orofos = orofos;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getRenovationYear() {
		return this.renovationyear;
	}

	public void setRenovationYear(Integer renovationyear) {
		this.renovationyear = renovationyear;
	}

	public List<PropertyImage> getPropertyimages() {
        if (propertyimages == null){
        	propertyimages = new ArrayList<PropertyImage>();
        }
		return this.propertyimages;
	}

	public void setPropertyimages(List<PropertyImage> propertyimages) {
		this.propertyimages = propertyimages;
	}

	public PropertyImage addPropertyimage(PropertyImage propertyimage) {
		getPropertyimages().add(propertyimage);
		propertyimage.setProperty(this);

		return propertyimage;
	}

	public PropertyImage removePropertyimage(PropertyImage propertyimage) {
		getPropertyimages().remove(propertyimage);
		propertyimage.setProperty(null);

		return propertyimage;
	}
	
	@JsonProperty("topothesia")
	@JsonSerialize(using = JTSGeomToGeoJSONSerializer.class)
	public Point getTopothesia() {
		return this.topothesia;
	}
	
	@JsonProperty("topothesia")
	@JsonDeserialize(using = JTSGeomToGeoJSONDeserializer.class)
	public void setTopothesia(Point topothesia) {
		this.topothesia = topothesia;
	}
	
	/*
	 * Less flexible approach
	 
	@Column(name="topothesia")
	@ColumnTransformer(
		      read="ST_AsGeoJSON(topothesia)", 
		      write="ST_GeomFromGeoJSON(?)")
	private String topothesia;
	
	public String getTopothesiaGeoJSON() {
		return this.topothesiaGeoJSON;
	}

	public void setTopothesiaGeoJSON(String topothesiaGeoJSON) {
		this.topothesiaGeoJSON = topothesiaGeoJSON;
	}
	*/
    
}