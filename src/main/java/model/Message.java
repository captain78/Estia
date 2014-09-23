package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
@Table(name="message")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String message;
	private Boolean read;
	private Property property;
	private User user;

	public Message() {
	}


	@Id
	@SequenceGenerator(name="MESSAGE_ID_GENERATOR", sequenceName="MESSAGE_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MESSAGE_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(nullable=false, length=2147483647)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public Boolean getRead() {
		return this.read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}


	//bi-directional many-to-one association to Property
	@ManyToOne
	@JoinColumn(name="propertyid")
	public Property getProperty() {
		return this.property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}


	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userid")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}