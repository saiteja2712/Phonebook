package com.phone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Addnumber {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Long mobilenumber;
	private String name;
	@ManyToOne
	private Phoneuser phoneuser;
	public Addnumber(int id, Long mobilenumber, String name, Phoneuser phoneuser) {
		super();
		this.id = id;
		this.mobilenumber = mobilenumber;
		this.name = name;
		this.phoneuser = phoneuser;
	}
	public Addnumber() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Phoneuser getPhoneuser() {
		return phoneuser;
	}
	public void setPhoneuser(Phoneuser phoneuser) {
		this.phoneuser = phoneuser;
	}
	@Override
	public String toString() {
		return "Addnumber [id=" + id + ", mobilenumber=" + mobilenumber + ", name=" + name + ", phoneuser=" + phoneuser
				+ "]";
	}
	
}
