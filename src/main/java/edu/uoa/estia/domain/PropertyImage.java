package edu.uoa.estia.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the propertyimages database table.
 * 
 */
@Entity
@Table(name="propertyimages")
public class PropertyImage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="PROPERTYIMAGES_ID_GENERATOR", sequenceName="PROPERTYIMAGES_ID_SEC", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROPERTYIMAGES_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;
	
	@Column(name="image_path", nullable=false, length=150)
	private String imagePath;
	
	//bi-directional many-to-one association to Property
	@ManyToOne
	@JoinColumn(name="property_id", nullable=false)
	private Property property;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Property getProperty() {
		return this.property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

}