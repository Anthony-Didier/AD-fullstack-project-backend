package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "UserType")
public class UserType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idTypeUser;
	public String typeUser;
	
	public UserType() {
		
	}
	
	public UserType(String typeUser) {
		super();
		this.typeUser = typeUser;
	}
	
	@OneToMany(mappedBy = "userType", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<User> users = new ArrayList<>();

	public int getIdTypeUser() {
		return idTypeUser;
	}

	public void setIdTypeUser(int idTypeUser) {
		this.idTypeUser = idTypeUser;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
