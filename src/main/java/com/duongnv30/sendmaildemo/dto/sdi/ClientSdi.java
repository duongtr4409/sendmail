package com.duongnv30.sendmaildemo.dto.sdi;

import lombok.Data;

@Data
public class ClientSdi {
    private String name;
    private String username;
    private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ClientSdi(String name, String username, String email) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
	}
	public ClientSdi() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
} 