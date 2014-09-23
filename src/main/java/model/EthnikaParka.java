package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ethnika_parka database table.
 * 
 */
@Entity
@Table(name="ethnika_parka")
@NamedQuery(name="EthnikaParka.findAll", query="SELECT e FROM EthnikaParka e")
public class EthnikaParka implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id0;
	private BigDecimal area;
	private String fek;
	private Object geom;
	private BigDecimal hectares;
	private Integer id;
	private String kode;
	private String name;
	private Integer objectid;
	private BigDecimal perimeter;
	private BigDecimal shapeArea;
	private BigDecimal shapeLen;
	private String updated;
	private String zone;

	public EthnikaParka() {
	}


	@Id
	@SequenceGenerator(name="ETHNIKA_PARKA_ID0_GENERATOR", sequenceName="ETHNIKA_PARKA_ID_0_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ETHNIKA_PARKA_ID0_GENERATOR")
	@Column(name="id_0", unique=true, nullable=false)
	public Integer getId0() {
		return this.id0;
	}

	public void setId0(Integer id0) {
		this.id0 = id0;
	}


	@Column(name="area_", precision=131089)
	public BigDecimal getArea() {
		return this.area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}


	@Column(length=62)
	public String getFek() {
		return this.fek;
	}

	public void setFek(String fek) {
		this.fek = fek;
	}


	public Object getGeom() {
		return this.geom;
	}

	public void setGeom(Object geom) {
		this.geom = geom;
	}


	@Column(precision=131089)
	public BigDecimal getHectares() {
		return this.hectares;
	}

	public void setHectares(BigDecimal hectares) {
		this.hectares = hectares;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(length=7)
	public String getKode() {
		return this.kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}


	@Column(length=94)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Integer getObjectid() {
		return this.objectid;
	}

	public void setObjectid(Integer objectid) {
		this.objectid = objectid;
	}


	@Column(precision=131089)
	public BigDecimal getPerimeter() {
		return this.perimeter;
	}

	public void setPerimeter(BigDecimal perimeter) {
		this.perimeter = perimeter;
	}


	@Column(name="shape_area", precision=131089)
	public BigDecimal getShapeArea() {
		return this.shapeArea;
	}

	public void setShapeArea(BigDecimal shapeArea) {
		this.shapeArea = shapeArea;
	}


	@Column(name="shape_len", precision=131089)
	public BigDecimal getShapeLen() {
		return this.shapeLen;
	}

	public void setShapeLen(BigDecimal shapeLen) {
		this.shapeLen = shapeLen;
	}


	@Column(length=10)
	public String getUpdated() {
		return this.updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}


	@Column(length=176)
	public String getZone() {
		return this.zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

}