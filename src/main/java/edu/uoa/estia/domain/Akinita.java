package edu.uoa.estia.domain;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Point;

import edu.uoa.estia.utils.GeometryUtils;
import edu.uoa.estia.utils.JTSGeomToGeoJSONDeserializer;
import edu.uoa.estia.utils.JTSGeomToGeoJSONSerializer;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * The persistent class for the akinita database table.
 * 
 */
@Entity
@Table (name="Akinita")
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
	 * Another, less flexible approach
	 * 

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