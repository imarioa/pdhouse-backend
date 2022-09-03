package br.ufc.backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Announcement {
	@Id
	@GeneratedValue
	private int id;
	private String owner;
	private String title;
	private String city;
	private String state;
	private String district;
	private String street;
	private String number_house;
	private String type;
	private double m_square_ground;
	private int qt_bedrooms;
	private int qt_bathrooms;
	private int qt_garage_spaces;
	private double price;
	private String status;
	
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@JsonIgnore
	private Usuario usuario;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getM_square_ground() {
		return m_square_ground;
	}

	public void setM_square_ground(double m_square_ground) {
		this.m_square_ground = m_square_ground;
	}

	public int getQt_bedrooms() {
		return qt_bedrooms;
	}

	public void setQt_bedrooms(int qt_bedrooms) {
		this.qt_bedrooms = qt_bedrooms;
	}

	public int getQt_bathrooms() {
		return qt_bathrooms;
	}

	public void setQt_bathrooms(int qt_bathrooms) {
		this.qt_bathrooms = qt_bathrooms;
	}

	public int getQt_garage_spaces() {
		return qt_garage_spaces;
	}

	public void setQt_garage_spaces(int qt_garage_spaces) {
		this.qt_garage_spaces = qt_garage_spaces;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario Usuario) {
		this.usuario = Usuario;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber_house() {
		return number_house;
	}

	public void setNumber_house(String number_house) {
		this.number_house = number_house;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Announcement(int id, String owner, String title, String city, String state, String district, String street,
			String number_house, String type, double m_square_ground, int qt_bedrooms, int qt_bathrooms,
			int qt_garage_spaces, double price, String status, Usuario usuario) {
		super();
		this.id = id;
		this.owner = owner;
		this.title = title;
		this.city = city;
		this.state = state;
		this.district = district;
		this.street = street;
		this.number_house = number_house;
		this.type = type;
		this.m_square_ground = m_square_ground;
		this.qt_bedrooms = qt_bedrooms;
		this.qt_bathrooms = qt_bathrooms;
		this.qt_garage_spaces = qt_garage_spaces;
		this.price = price;
		this.status = status;
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Announcement [id=" + id + ", title=" + title + ", city=" + city + ", state=" + state + ", district="
				+ district + ", street=" + street + ", number_house=" + number_house + ", type=" + type
				+ ", m_square_ground=" + m_square_ground + ", qt_bedrooms=" + qt_bedrooms + ", qt_bathrooms="
				+ qt_bathrooms + ", qt_garage_spaces=" + qt_garage_spaces + ", price=" + price + ", status=" + status
				+ ", usuario=" + usuario + "]";
	}
	
	public Announcement() {
		super();
		// TODO Auto-generated constructor stub
	}
}
