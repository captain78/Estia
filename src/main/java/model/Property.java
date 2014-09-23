package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the property database table.
 * 
 */
@Entity
@Table(name="property")
@NamedQuery(name="Property.findAll", query="SELECT p FROM Property p")
public class Property implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean centralheating;
	private Integer constructionyear;
	private String dieythinsi;
	private float emvadon;
	private double koinoxrista;
	private Integer orofos;
	private double price;
	private Integer renovationyear;
	private Object topothesia;
	private Propertytypecode propertytypecode;
	private List<Propertyimage> propertyimages;
	private List<Propertystatus> propertystatuses;
	private List<Message> messages;
	private User user;

	public Property() {
	}


	@Id
	@SequenceGenerator(name="PROPERTY_ID_GENERATOR", sequenceName="PROPERTY_ID_SEC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROPERTY_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(nullable=false)
	public Boolean getCentralheating() {
		return this.centralheating;
	}

	public void setCentralheating(Boolean centralheating) {
		this.centralheating = centralheating;
	}


	@Column(nullable=false)
	public Integer getConstructionyear() {
		return this.constructionyear;
	}

	public void setConstructionyear(Integer constructionyear) {
		this.constructionyear = constructionyear;
	}


	@Column(nullable=false, length=150)
	public String getDieythinsi() {
		return this.dieythinsi;
	}

	public void setDieythinsi(String dieythinsi) {
		this.dieythinsi = dieythinsi;
	}


	@Column(nullable=false)
	public float getEmvadon() {
		return this.emvadon;
	}

	public void setEmvadon(float emvadon) {
		this.emvadon = emvadon;
	}


	public double getKoinoxrista() {
		return this.koinoxrista;
	}

	public void setKoinoxrista(double koinoxrista) {
		this.koinoxrista = koinoxrista;
	}


	@Column(nullable=false)
	public Integer getOrofos() {
		return this.orofos;
	}

	public void setOrofos(Integer orofos) {
		this.orofos = orofos;
	}


	@Column(nullable=false)
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	@Column(nullable=false)
	public Integer getRenovationyear() {
		return this.renovationyear;
	}

	public void setRenovationyear(Integer renovationyear) {
		this.renovationyear = renovationyear;
	}


	public Object getTopothesia() {
		return this.topothesia;
	}

	public void setTopothesia(Object topothesia) {
		this.topothesia = topothesia;
	}


	//bi-directional many-to-one association to Propertytypecode
	@ManyToOne
	@JoinColumn(name="type", nullable=false)
	public Propertytypecode getPropertytypecode() {
		return this.propertytypecode;
	}

	public void setPropertytypecode(Propertytypecode propertytypecode) {
		this.propertytypecode = propertytypecode;
	}


	//bi-directional many-to-one association to Propertyimage
	@OneToMany(mappedBy="property", fetch=FetchType.EAGER)
	public List<Propertyimage> getPropertyimages() {
		return this.propertyimages;
	}

	public void setPropertyimages(List<Propertyimage> propertyimages) {
		this.propertyimages = propertyimages;
	}

	public Propertyimage addPropertyimage(Propertyimage propertyimage) {
		getPropertyimages().add(propertyimage);
		propertyimage.setProperty(this);

		return propertyimage;
	}

	public Propertyimage removePropertyimage(Propertyimage propertyimage) {
		getPropertyimages().remove(propertyimage);
		propertyimage.setProperty(null);

		return propertyimage;
	}


	//bi-directional many-to-one association to Propertystatus
	@OneToMany(mappedBy="property", fetch=FetchType.EAGER)
	public List<Propertystatus> getPropertystatuses() {
		return this.propertystatuses;
	}

	public void setPropertystatuses(List<Propertystatus> propertystatuses) {
		this.propertystatuses = propertystatuses;
	}

	public Propertystatus addPropertystatus(Propertystatus propertystatus) {
		getPropertystatuses().add(propertystatus);
		propertystatus.setProperty(this);

		return propertystatus;
	}

	public Propertystatus removePropertystatus(Propertystatus propertystatus) {
		getPropertystatuses().remove(propertystatus);
		propertystatus.setProperty(null);

		return propertystatus;
	}


	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="property", fetch=FetchType.EAGER)
	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setProperty(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setProperty(null);

		return message;
	}


	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userid", nullable=false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}