package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the propertystatus database table.
 * 
 */
@Entity
@Table(name="propertystatus")
@NamedQuery(name="Propertystatus.findAll", query="SELECT p FROM Propertystatus p")
public class Propertystatus implements Serializable {
	private static final long serialVersionUID = 1L;
	private PropertystatusPK id;
	private Property property;
	private Propertystatuscode propertystatuscode;

	public Propertystatus() {
	}


	@EmbeddedId
	public PropertystatusPK getId() {
		return this.id;
	}

	public void setId(PropertystatusPK id) {
		this.id = id;
	}


	//bi-directional many-to-one association to Property
	@ManyToOne
	@JoinColumn(name="propertyid", nullable=false, insertable=false, updatable=false)
	public Property getProperty() {
		return this.property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}


	//bi-directional many-to-one association to Propertystatuscode
	@ManyToOne
	@JoinColumn(name="propertyid", nullable=false, insertable=false, updatable=false)
	public Propertystatuscode getPropertystatuscode() {
		return this.propertystatuscode;
	}

	public void setPropertystatuscode(Propertystatuscode propertystatuscode) {
		this.propertystatuscode = propertystatuscode;
	}

}