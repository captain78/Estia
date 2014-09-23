package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the akinita database table.
 * 
 */
@Entity
@Table(name="akinita")
@NamedQuery(name="Akinita.findAll", query="SELECT a FROM Akinita a")
public class Akinita implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String dieythinsi;
	private String idioktitis;
	private String topothesia;

	public Akinita() {
	}


	@Id
	@SequenceGenerator(name="AKINITA_ID_GENERATOR", sequenceName="AKINITA_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AKINITA_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(nullable=false, length=150)
	public String getDieythinsi() {
		return this.dieythinsi;
	}

	public void setDieythinsi(String dieythinsi) {
		this.dieythinsi = dieythinsi;
	}


	@Column(nullable=false, length=50)
	public String getIdioktitis() {
		return this.idioktitis;
	}

	public void setIdioktitis(String idioktitis) {
		this.idioktitis = idioktitis;
	}


	public String getTopothesia() {
		return this.topothesia;
	}

	public void setTopothesia(String topothesia) {
		this.topothesia = topothesia;
	}

}