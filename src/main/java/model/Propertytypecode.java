package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the propertytypecodes database table.
 * 
 */
@Entity
@Table(name="propertytypecodes")
@NamedQuery(name="Propertytypecode.findAll", query="SELECT p FROM Propertytypecode p")
public class Propertytypecode implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String onoma;
	private String type;
	private List<Property> properties;

	public Propertytypecode() {
	}


	@Id
	@SequenceGenerator(name="PROPERTYTYPECODES_ID_GENERATOR", sequenceName="PROPERTYTYPECODES_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROPERTYTYPECODES_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(length=2147483647)
	public String getOnoma() {
		return this.onoma;
	}

	public void setOnoma(String onoma) {
		this.onoma = onoma;
	}


	@Column(length=2147483647)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	//bi-directional many-to-one association to Property
	@OneToMany(mappedBy="propertytypecode", fetch=FetchType.EAGER)
	public List<Property> getProperties() {
		return this.properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public Property addProperty(Property property) {
		getProperties().add(property);
		property.setPropertytypecode(this);

		return property;
	}

	public Property removeProperty(Property property) {
		getProperties().remove(property);
		property.setPropertytypecode(null);

		return property;
	}

}