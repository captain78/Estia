package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the oria_nomwn database table.
 * 
 */
@Entity
@Table(name="oria_nomwn")
@NamedQuery(name="OriaNomwn.findAll", query="SELECT o FROM OriaNomwn o")
public class OriaNomwn implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Object geom;
	private BigDecimal shapeLeng;
	private Integer typeLand;

	public OriaNomwn() {
	}


	@Id
	@SequenceGenerator(name="ORIA_NOMWN_ID_GENERATOR", sequenceName="ORIA_NOMWN_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORIA_NOMWN_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Object getGeom() {
		return this.geom;
	}

	public void setGeom(Object geom) {
		this.geom = geom;
	}


	@Column(name="shape_leng", precision=131089)
	public BigDecimal getShapeLeng() {
		return this.shapeLeng;
	}

	public void setShapeLeng(BigDecimal shapeLeng) {
		this.shapeLeng = shapeLeng;
	}


	@Column(name="type_land")
	public Integer getTypeLand() {
		return this.typeLand;
	}

	public void setTypeLand(Integer typeLand) {
		this.typeLand = typeLand;
	}

}