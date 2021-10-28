package com.application.server.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import interfaces.HasValue;

@Entity
@Table(name = "user")
public class User {

	public enum UserType implements HasValue<String> {

		USER("user"), ADMIN("admin");

		// ***********************************************************************************************************
		// Section de code : Variables
		// ***********************************************************************************************************

		private String value;

		// ***********************************************************************************************************
		// Section de code : Constructeurs
		// ***********************************************************************************************************

		private UserType(String value) {
			this.value = value;
		}

		// ***********************************************************************************************************
		// Section de code : Surcharges
		// ***********************************************************************************************************

		@Override
		public String getValue() {
			return this.value;
		}

		@Override
		public String getValueAsString() {
			return this.getValue();
		}

	}

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "USER_NAME")
	private String name;

	@Column(name = "USER_LOGIN")
	private String login;

	@Column(name = "USER_PASSWORD")
	private String password;

	@Column(name = "USER_TYPE", columnDefinition = "ENUM('ADMIN', 'USER')")
	@Enumerated(EnumType.STRING)
	private UserType type;

	@Column(name = "USER_IMG_PATH")
	private String imagePath;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public User() {
	}

	public User(String name, String login, String password, UserType type) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.type = type;
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.id == null ? 0 : this.id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final User other = (User) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User : " + " Name = " + this.name + ", Login = " + this.login + ", Password = " + this.password
				+ ", Type = " + this.type;
	}

	// ***********************************************************************************************************
	// Section de code : Accesseurs
	// ***********************************************************************************************************

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getType() {
		return this.type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
