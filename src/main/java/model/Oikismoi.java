package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the oikismoi database table.
 * 
 */
@Entity
@Table(name="oikismoi")
@NamedQuery(name="Oikismoi.findAll", query="SELECT o FROM Oikismoi o")
public class Oikismoi implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String codeDiam;
	private String codeGdiam;
	private String codeNom;
	private String codeOik;
	private String codeOta;
	private double edraDiam;
	private Object geom;
	private double h;
	private BigDecimal lat;
	private BigDecimal lon;
	private String nameDiam;
	private String nameGdiam;
	private String nameNom;
	private String nameOik;
	private String nameOta;
	private String namefOik;
	private double objectid;
	private BigDecimal pointX;
	private BigDecimal pointY;

	public Oikismoi() {
	}


	@Id
	@SequenceGenerator(name="OIKISMOI_ID_GENERATOR", sequenceName="OIKISMOI_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OIKISMOI_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name="code_diam", length=8)
	public String getCodeDiam() {
		return this.codeDiam;
	}

	public void setCodeDiam(String codeDiam) {
		this.codeDiam = codeDiam;
	}


	@Column(name="code_gdiam", length=1)
	public String getCodeGdiam() {
		return this.codeGdiam;
	}

	public void setCodeGdiam(String codeGdiam) {
		this.codeGdiam = codeGdiam;
	}


	@Column(name="code_nom", length=2)
	public String getCodeNom() {
		return this.codeNom;
	}

	public void setCodeNom(String codeNom) {
		this.codeNom = codeNom;
	}


	@Column(name="code_oik", length=8)
	public String getCodeOik() {
		return this.codeOik;
	}

	public void setCodeOik(String codeOik) {
		this.codeOik = codeOik;
	}


	@Column(name="code_ota", length=8)
	public String getCodeOta() {
		return this.codeOta;
	}

	public void setCodeOta(String codeOta) {
		this.codeOta = codeOta;
	}


	@Column(name="edra_diam")
	public double getEdraDiam() {
		return this.edraDiam;
	}

	public void setEdraDiam(double edraDiam) {
		this.edraDiam = edraDiam;
	}


	public Object getGeom() {
		return this.geom;
	}

	public void setGeom(Object geom) {
		this.geom = geom;
	}


	public double getH() {
		return this.h;
	}

	public void setH(double h) {
		this.h = h;
	}


	@Column(precision=131089)
	public BigDecimal getLat() {
		return this.lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}


	@Column(precision=131089)
	public BigDecimal getLon() {
		return this.lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}


	@Column(name="name_diam", length=100)
	public String getNameDiam() {
		return this.nameDiam;
	}

	public void setNameDiam(String nameDiam) {
		this.nameDiam = nameDiam;
	}


	@Column(name="name_gdiam", length=50)
	public String getNameGdiam() {
		return this.nameGdiam;
	}

	public void setNameGdiam(String nameGdiam) {
		this.nameGdiam = nameGdiam;
	}


	@Column(name="name_nom", length=50)
	public String getNameNom() {
		return this.nameNom;
	}

	public void setNameNom(String nameNom) {
		this.nameNom = nameNom;
	}


	@Column(name="name_oik", length=98)
	public String getNameOik() {
		return this.nameOik;
	}

	public void setNameOik(String nameOik) {
		this.nameOik = nameOik;
	}


	@Column(name="name_ota", length=50)
	public String getNameOta() {
		return this.nameOta;
	}

	public void setNameOta(String nameOta) {
		this.nameOta = nameOta;
	}


	@Column(name="namef_oik", length=100)
	public String getNamefOik() {
		return this.namefOik;
	}

	public void setNamefOik(String namefOik) {
		this.namefOik = namefOik;
	}


	public double getObjectid() {
		return this.objectid;
	}

	public void setObjectid(double objectid) {
		this.objectid = objectid;
	}


	@Column(name="point_x", precision=131089)
	public BigDecimal getPointX() {
		return this.pointX;
	}

	public void setPointX(BigDecimal pointX) {
		this.pointX = pointX;
	}


	@Column(name="point_y", precision=131089)
	public BigDecimal getPointY() {
		return this.pointY;
	}

	public void setPointY(BigDecimal pointY) {
		this.pointY = pointY;
	}

}