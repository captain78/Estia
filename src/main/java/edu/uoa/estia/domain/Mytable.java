package edu.uoa.estia.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;

/**
 * The persistent class for the mytable database table.
 * 
 */
@Entity
@Table(name="mytable")
@NamedQuery(name="Mytable.findAll", query="SELECT m FROM Mytable m")
public class Mytable implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="MYTABLE_ID_GENERATOR", sequenceName="MYTABLE_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MYTABLE_ID_GENERATOR")
	@Column(name="id", unique=true, nullable=false)
	private Integer id;	   
	
	@Type(type="org.hibernate.spatial.GeometryType")
	private Point mygeom;
	
	private Integer myint;
	private String mytext;

	public Mytable() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Point getMygeom() {
		return this.mygeom;
	}

	public void setMygeom(Point mygeom) {
		this.mygeom = mygeom;
	}


	public Integer getMyint() {
		return this.myint;
	}

	public void setMyint(Integer myint) {
		this.myint = myint;
	}


	@Column(length=2147483647)
	public String getMytext() {
		return this.mytext;
	}

	public void setMytext(String mytext) {
		this.mytext = mytext;
	}

}