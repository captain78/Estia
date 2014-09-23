package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the mytable database table.
 * 
 */
@Entity
@Table(name="mytable")
@NamedQuery(name="Mytable.findAll", query="SELECT m FROM Mytable m")
public class Mytable implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean boolcol;
	private double doublecol;
	private String mygeom;
	private Integer myint;
	private String mytext;
	private BigDecimal price;
	private float realcol;

	public Mytable() {
	}


	@Id
	@SequenceGenerator(name="MYTABLE_ID_GENERATOR", sequenceName="MYTABLE_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MYTABLE_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Boolean getBoolcol() {
		return this.boolcol;
	}

	public void setBoolcol(Boolean boolcol) {
		this.boolcol = boolcol;
	}


	public double getDoublecol() {
		return this.doublecol;
	}

	public void setDoublecol(double doublecol) {
		this.doublecol = doublecol;
	}


	public String getMygeom() {
		return this.mygeom;
	}

	public void setMygeom(String mygeom) {
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


	@Column(precision=131089)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public float getRealcol() {
		return this.realcol;
	}

	public void setRealcol(float realcol) {
		this.realcol = realcol;
	}

}