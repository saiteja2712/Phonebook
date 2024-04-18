package com.phone.loginRequest;

public class LoginRequest {
	public String Email;
	private String password;
	public LoginRequest(String email, String password) {
		super();
		Email = email;
		this.password = password;
	}
	public LoginRequest() {
		super();
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginRequest [Email=" + Email + ", password=" + password + "]";
	}
	
}
