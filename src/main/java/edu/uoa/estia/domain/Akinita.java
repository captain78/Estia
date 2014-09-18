package edu.uoa.estia.domain;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vividsolutions.jts.geom.Point;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * The persistent class for the akinita database table.
 * 
 */
@Entity
@Table (name="Akinita")
//@NamedQuery(name="Akinita.findAll", query="SELECT a FROM Akinita a")
public class Akinita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AKINITA_ID_GENERATOR", sequenceName="AKINITA_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AKINITA_ID_GENERATOR")
	private Integer id;

	private String dieythinsi;

	private String idioktitis;

    @JsonIgnore
	@Column(columnDefinition="Geometry", name="topothesia")
	@Type(type="org.hibernate.spatial.GeometryType")
	private Point topothesia;
	
	/*
	@Column(name="topothesia")
	@ColumnTransformer(
		      read="ST_AsGeoJSON(topothesia)", 
		      write="ST_GeomFromGeoJSON(?)")
	private String topothesia;
	*/
    
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
	
	/*
	public String getTopothesiaGeoJSON() {
		return this.topothesiaGeoJSON;
	}

	public void setTopothesiaGeoJSON(String topothesiaGeoJSON) {
		this.topothesiaGeoJSON = topothesiaGeoJSON;
	}
	*/

}