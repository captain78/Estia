package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usertypecodes database table.
 * 
 */
@Entity
@Table(name="usertypecodes")
@NamedQuery(name="Usertypecode.findAll", query="SELECT u FROM Usertypecode u")
public class Usertypecode implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String type;

	public Usertypecode() {
	}


	@Id
	@SequenceGenerator(name="USERTYPECODES_ID_GENERATOR", sequenceName="USERTYPECODES_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERTYPECODES_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(length=2147483647)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}