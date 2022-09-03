package br.ufc.backend.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
public class Usuario implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login_generator")
	@SequenceGenerator(name = "login_generator", sequenceName = "login_seq", allocationSize = 1)
	private int id;
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String cpf;
	private String tel;
	private String address;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
	
	@OneToMany (mappedBy = "usuario")
    private List<Announcement> announcements;
	
	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	@JsonIgnore
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Role> getRoles() {
		return roles;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	 public List<Announcement> getAnnouncements() {
	        return announcements;
	 	}
	 
	    public void setFeedbacks(List<Announcement> announcements) {
	        this.announcements = announcements;
	    }
	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", cpf=" + cpf
				+ ", tel=" + tel + ", address=" + address + ", announcements=" + announcements + "]";
	}
	public Usuario(int id, String name, String email, String password, String cpf, String tel, String address,
			List<Announcement> announcements) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.cpf = cpf;
		this.tel = tel;
		this.address = address;
		this.announcements = announcements;
	}
	
	public Usuario() {
        super();
    }
}
