package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oria_dhmwn_kallikraths database table.
 * 
 */
@Entity
@Table(name="oria_dhmwn_kallikraths")
@NamedQuery(name="OriaDhmwnKallikrath.findAll", query="SELECT o FROM OriaDhmwnKallikrath o")
public class OriaDhmwnKallikrath implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Object geom;
	private String kwdYpes;
	private String name;

	public OriaDhmwnKallikrath() {
	}


	@Id
	@SequenceGenerator(name="ORIA_DHMWN_KALLIKRATHS_ID_GENERATOR", sequenceName="ORIA_DHMWN_KALLIKRATHS_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORIA_DHMWN_KALLIKRATHS_ID_GENERATOR")
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


	@Column(name="kwd_ypes", length=4)
	public String getKwdYpes() {
		return this.kwdYpes;
	}

	public void setKwdYpes(String kwdYpes) {
		this.kwdYpes = kwdYpes;
	}


	@Column(length=59)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}