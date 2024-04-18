package com.phone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="phone")
@Data
public class Phoneuser {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private Long mobilenumber;
	private String password;
	public Phoneuser(int id, String firstname, String lastname, String email, Long mobilenumber, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.password = password;
	}
	public Phoneuser() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Phoneuser [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", mobilenumber=" + mobilenumber + ", password=" + password + "]";
	}
		
	
	

}
