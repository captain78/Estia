package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sortingalgorithmscodes database table.
 * 
 */
@Entity
@Table(name="sortingalgorithmscodes")
@NamedQuery(name="Sortingalgorithmscode.findAll", query="SELECT s FROM Sortingalgorithmscode s")
public class Sortingalgorithmscode implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String description;
	private String name;

	public Sortingalgorithmscode() {
	}


	@Id
	@SequenceGenerator(name="SORTINGALGORITHMSCODES_ID_GENERATOR", sequenceName="SORTINGALGORITHMSCODES_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SORTINGALGORITHMSCODES_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(nullable=false, length=2147483647)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Column(nullable=false, length=2147483647)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}