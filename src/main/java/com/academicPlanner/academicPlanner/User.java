package com.academicPlanner.academicPlanner;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
	
	// ATRIBUTOS
	
	@Id
	@GeneratedValue
	@Column (name="user_id")
	private Long id;
	
	@Column (name="user_name")
	private String name;
	
	@Column (name="user_lastName")
	private String lastName;
	
	@Column (name="user_email")
	private String email;
	
	@Column (name="user_password")
	private String password;
	
	
	// CONSTRUTORES 
	
	protected User() {};
	
	public User(Long id, String name, String lastName, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	
	// GETTERS E SETTERS

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

	public void setPassword(String Password) {
		this.password = Password;
	}
	
	
}
