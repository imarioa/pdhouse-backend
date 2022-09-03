package br.ufc.backend.dto;

public class AnnouncementDTO {
	private String title;
	private double m_square_ground;
	private double m_square_built;
	private int qt_bedrooms;
	private int qt_bathrooms;
	private int qt_garage_spaces;
	private double price;
	private String status;
	private String name;
	private String email;
	private String password;
	private String cpf;
	private String tel;
	private String address;
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
	public double getM_square_built() {
		return m_square_built;
	}
	public void setM_square_built(double m_square_built) {
		this.m_square_built = m_square_built;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "AnnouncementDTO [title=" + title + ", m_square_ground=" + m_square_ground + ", m_square_built="
				+ m_square_built + ", qt_bedrooms=" + qt_bedrooms + ", qt_bathrooms=" + qt_bathrooms
				+ ", qt_garage_spaces=" + qt_garage_spaces + ", price=" + price + ", status=" + status + ", name="
				+ name + ", email=" + email + ", password=" + password + ", cpf=" + cpf + ", tel=" + tel + ", address="
				+ address + "]";
	}
	public AnnouncementDTO(String title, double m_square_ground, double m_square_built, int qt_bedrooms,
			int qt_bathrooms, int qt_garage_spaces, double price, String status, String name, String email,
			String password, String cpf, String tel, String address) {
		super();
		this.title = title;
		this.m_square_ground = m_square_ground;
		this.m_square_built = m_square_built;
		this.qt_bedrooms = qt_bedrooms;
		this.qt_bathrooms = qt_bathrooms;
		this.qt_garage_spaces = qt_garage_spaces;
		this.price = price;
		this.status = status;
		this.name = name;
		this.email = email;
		this.password = password;
		this.cpf = cpf;
		this.tel = tel;
		this.address = address;
	}
	public AnnouncementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
