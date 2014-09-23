package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String email;
	private String firstname;
	private String lastname;
	private String password;
	private String telephone;
	private BigDecimal type;
	private String username;
	private List<Message> messages;
	private List<Property> properties;
	private List<Rolecode> rolecodes;

	public User() {
	}


	@Id
	@SequenceGenerator(name="USERS_ID_GENERATOR", sequenceName="USERS_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(nullable=false, length=2147483647)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(length=2147483647)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	@Column(nullable=false, length=2147483647)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	@Column(length=2147483647)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Column(nullable=false, length=2147483647)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	@Column(nullable=false, precision=131089)
	public BigDecimal getType() {
		return this.type;
	}

	public void setType(BigDecimal type) {
		this.type = type;
	}


	@Column(nullable=false, length=2147483647)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setUser(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setUser(null);

		return message;
	}


	//bi-directional many-to-one association to Property
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	public List<Property> getProperties() {
		return this.properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public Property addProperty(Property property) {
		getProperties().add(property);
		property.setUser(this);

		return property;
	}

	public Property removeProperty(Property property) {
		getProperties().remove(property);
		property.setUser(null);

		return property;
	}


	//bi-directional many-to-many association to Rolecode
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="userrole"
		, joinColumns={
			@JoinColumn(name="userid", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="roleid", nullable=false)
			}
		)
	public List<Rolecode> getRolecodes() {
		return this.rolecodes;
	}

	public void setRolecodes(List<Rolecode> rolecodes) {
		this.rolecodes = rolecodes;
	}

}