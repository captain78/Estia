package edu.uoa.estia.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.vividsolutions.jts.geom.Point;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * The persistent class for the akinita database table.
 * 
 */
@Entity
@NamedQuery(name="Akinita.findAll", query="SELECT a FROM Akinita a")
public class Akinita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AKINITA_ID_GENERATOR", sequenceName="AKINITA_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AKINITA_ID_GENERATOR")
	private Integer id;

	private String dieythinsi;

	private String idioktitis;

	@Type(type="org.hibernate.spatial.GeometryType")
	private Point topothesia;

	public Akinita() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDieythinsi() {
		return this.dieythinsi;
	}

	public void setDieythinsi(String dieythinsi) {
		this.dieythinsi = dieythinsi;
	}

	public String getIdioktitis() {
		return this.idioktitis;
	}

	public void setIdioktitis(String idioktitis) {
		this.idioktitis = idioktitis;
	}

	public Point getTopothesia() {
		return this.topothesia;
	}

	public void setTopothesia(Point topothesia) {
		this.topothesia = topothesia;
	}

}