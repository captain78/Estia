package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the propertyimages database table.
 * 
 */
@Entity
@Table(name="propertyimages")
@NamedQuery(name="Propertyimage.findAll", query="SELECT p FROM Propertyimage p")
public class Propertyimage implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String imagePath;
	private Property property;

	public Propertyimage() {
	}


	@Id
	@SequenceGenerator(name="PROPERTYIMAGES_ID_GENERATOR", sequenceName="PROPERTYIMAGES_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROPERTYIMAGES_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name="image_path", nullable=false, length=150)
	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	//bi-directional many-to-one association to Property
	@ManyToOne
	@JoinColumn(name="property_id", nullable=false)
	public Property getProperty() {
		return this.property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

}