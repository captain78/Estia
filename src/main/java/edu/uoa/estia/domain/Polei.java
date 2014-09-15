package edu.uoa.estia.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the poleis database table.
 * 
 */
@Entity
@Table(name="poleis")
@NamedQuery(name="Polei.findAll", query="SELECT p FROM Polei p")
public class Polei implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POLEIS_ID_GENERATOR", sequenceName="POLEIS_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POLEIS_ID_GENERATOR")
	private Integer id;

	private String geom;

	private String name;

	private String onoma;

	public Polei() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGeom() {
		return this.geom;
	}

	public void setGeom(String geom) {
		this.geom = geom;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOnoma() {
		return this.onoma;
	}

	public void setOnoma(String onoma) {
		this.onoma = onoma;
	}

}