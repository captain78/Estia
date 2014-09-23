package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the oria_diamerismatwn database table.
 * 
 */
@Entity
@Table(name="oria_diamerismatwn")
@NamedQuery(name="OriaDiamerismatwn.findAll", query="SELECT o FROM OriaDiamerismatwn o")
public class OriaDiamerismatwn implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Object geom;
	private Integer objectid;
	private BigDecimal shapeLeng;

	public OriaDiamerismatwn() {
	}


	@Id
	@SequenceGenerator(name="ORIA_DIAMERISMATWN_ID_GENERATOR", sequenceName="ORIA_DIAMERISMATWN_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORIA_DIAMERISMATWN_ID_GENERATOR")
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


	public Integer getObjectid() {
		return this.objectid;
	}

	public void setObjectid(Integer objectid) {
		this.objectid = objectid;
	}


	@Column(name="shape_leng", precision=131089)
	public BigDecimal getShapeLeng() {
		return this.shapeLeng;
	}

	public void setShapeLeng(BigDecimal shapeLeng) {
		this.shapeLeng = shapeLeng;
	}

}