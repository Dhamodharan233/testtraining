package com.CVJ.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Erole name;

	public Role() {
		
	}

	public Role(int id, Erole name) {
		super();
		this.id = id;
		this.name = name;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Erole getName() {
		return name;
	}

	public void setName(Erole name) {
		this.name = name;
	}
	
	
	

}
