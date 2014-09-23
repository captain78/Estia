package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sxoleia database table.
 * 
 */
@Entity
@Table(name="sxoleia")
@NamedQuery(name="Sxoleia.findAll", query="SELECT s FROM Sxoleia s")
public class Sxoleia implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Object geom;
	private String onoma;

	public Sxoleia() {
	}


	@Id
	@SequenceGenerator(name="SXOLEIA_ID_GENERATOR", sequenceName="SXOLEIA_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SXOLEIA_ID_GENERATOR")
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


	@Column(length=2147483647)
	public String getOnoma() {
		return this.onoma;
	}

	public void setOnoma(String onoma) {
		this.onoma = onoma;
	}

}