package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rolecodes database table.
 * 
 */
@Entity
@Table(name="rolecodes")
@NamedQuery(name="Rolecode.findAll", query="SELECT r FROM Rolecode r")
public class Rolecode implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String type;
	private List<User> users;

	public Rolecode() {
	}


	@Id
	@SequenceGenerator(name="ROLECODES_ID_GENERATOR", sequenceName="ROLECODES_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLECODES_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(nullable=false, length=2147483647)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="rolecodes", fetch=FetchType.EAGER)
	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}