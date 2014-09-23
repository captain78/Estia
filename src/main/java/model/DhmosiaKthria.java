package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the dhmosia_kthria database table.
 * 
 */
@Entity
@Table(name="dhmosia_kthria")
@NamedQuery(name="DhmosiaKthria.findAll", query="SELECT d FROM DhmosiaKthria d")
public class DhmosiaKthria implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private double aA1;
	private String arithmos;
	private String diefthinsi;
	private String dimos1;
	private Object geom;
	private String ktirioYpi;
	private BigDecimal lat;
	private BigDecimal lng;
	private String megethos1;
	private String nomos1;
	private String perifereia;
	private double tetrapsifi;
	private String tk1;
	private String typos1;

	public DhmosiaKthria() {
	}


	@Id
	@SequenceGenerator(name="DHMOSIA_KTHRIA_ID_GENERATOR", sequenceName="DHMOSIA_KTHRIA_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DHMOSIA_KTHRIA_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name="a_a_1")
	public double getAA1() {
		return this.aA1;
	}

	public void setAA1(double aA1) {
		this.aA1 = aA1;
	}


	@Column(length=35)
	public String getArithmos() {
		return this.arithmos;
	}

	public void setArithmos(String arithmos) {
		this.arithmos = arithmos;
	}


	@Column(length=204)
	public String getDiefthinsi() {
		return this.diefthinsi;
	}

	public void setDiefthinsi(String diefthinsi) {
		this.diefthinsi = diefthinsi;
	}


	@Column(name="dimos_1", length=54)
	public String getDimos1() {
		return this.dimos1;
	}

	public void setDimos1(String dimos1) {
		this.dimos1 = dimos1;
	}


	public Object getGeom() {
		return this.geom;
	}

	public void setGeom(Object geom) {
		this.geom = geom;
	}


	@Column(name="ktirio_ypi", length=254)
	public String getKtirioYpi() {
		return this.ktirioYpi;
	}

	public void setKtirioYpi(String ktirioYpi) {
		this.ktirioYpi = ktirioYpi;
	}


	@Column(precision=131089)
	public BigDecimal getLat() {
		return this.lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}


	@Column(precision=131089)
	public BigDecimal getLng() {
		return this.lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}


	@Column(name="megethos_1", length=14)
	public String getMegethos1() {
		return this.megethos1;
	}

	public void setMegethos1(String megethos1) {
		this.megethos1 = megethos1;
	}


	@Column(name="nomos_1", length=32)
	public String getNomos1() {
		return this.nomos1;
	}

	public void setNomos1(String nomos1) {
		this.nomos1 = nomos1;
	}


	@Column(length=56)
	public String getPerifereia() {
		return this.perifereia;
	}

	public void setPerifereia(String perifereia) {
		this.perifereia = perifereia;
	}


	public double getTetrapsifi() {
		return this.tetrapsifi;
	}

	public void setTetrapsifi(double tetrapsifi) {
		this.tetrapsifi = tetrapsifi;
	}


	@Column(name="tk_1", length=10)
	public String getTk1() {
		return this.tk1;
	}

	public void setTk1(String tk1) {
		this.tk1 = tk1;
	}


	@Column(name="typos_1", length=176)
	public String getTypos1() {
		return this.typos1;
	}

	public void setTypos1(String typos1) {
		this.typos1 = typos1;
	}

}