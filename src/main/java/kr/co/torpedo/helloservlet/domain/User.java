package kr.co.torpedo.helloservlet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "id", columnDefinition = "int")
	private int id;
	@Column(name = "first_name", columnDefinition = "varchar(100)")
	private String firstName;
	@Column(name = "last_name", columnDefinition = "varchar(100)")
	private String lastName;
	@Column(name = "email", columnDefinition = "varchar(200)")
	private String email;
	@Column(name = "gender", columnDefinition = "varchar(200)")
	private String gender;
	@Column(name = "ip_address", columnDefinition = "varchar(200)")
	private String ipAddress;

	public User() {
	}

	public User(int id, String firstName, String lastName, String email, String gender, String ipAddress) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.ipAddress = ipAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
}
