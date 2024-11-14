package com.seroter.azure_basic_app.user;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "\"user\"")
public class User {

	@Id
	@SequenceGenerator(name = "user_sequence", allocationSize = 1, sequenceName = "user_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	private Long id;

	private String name;
	private String email;
	private String password;
	@Transient
	private LocalDate date;

	public User() {
	}

	public User(Long id, String name, String email, String password) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;

	}

	public User(String name, String email, String password) {

		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User(String name, String email) {

		this.name = name;
		this.email = email;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public LocalDate getDate() {
		return LocalDate.now();
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", date=" + date
				+ "]";
	}

}
