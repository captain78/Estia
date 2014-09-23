package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the propertystatuscodes database table.
 * 
 */
@Entity
@Table(name="propertystatuscodes")
@NamedQuery(name="Propertystatuscode.findAll", query="SELECT p FROM Propertystatuscode p")
public class Propertystatuscode implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String status;
	private List<Propertystatus> propertystatuses;

	public Propertystatuscode() {
	}


	@Id
	@SequenceGenerator(name="PROPERTYSTATUSCODES_ID_GENERATOR", sequenceName="PROPERTYSTATUSCODES_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROPERTYSTATUSCODES_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(nullable=false, length=2147483647)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	//bi-directional many-to-one association to Propertystatus
	@OneToMany(mappedBy="propertystatuscode", fetch=FetchType.EAGER)
	public List<Propertystatus> getPropertystatuses() {
		return this.propertystatuses;
	}

	public void setPropertystatuses(List<Propertystatus> propertystatuses) {
		this.propertystatuses = propertystatuses;
	}

	public Propertystatus addPropertystatus(Propertystatus propertystatus) {
		getPropertystatuses().add(propertystatus);
		propertystatus.setPropertystatuscode(this);

		return propertystatus;
	}

	public Propertystatus removePropertystatus(Propertystatus propertystatus) {
		getPropertystatuses().remove(propertystatus);
		propertystatus.setPropertystatuscode(null);

		return propertystatus;
	}

}