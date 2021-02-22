package com.uniovi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profesor {
	@Id
	public String dni;
	String name;
	String apellidos;
	String categoria;

	public Profesor() {}
	
	public Profesor(String dni, String name, String apellidos, String categoria) {
		this.dni = dni;
		this.name = name;
		this.apellidos = apellidos;
		this.categoria = categoria;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Profesor [dni=" + dni + ", Name=" + name + ", Apellidos=" + apellidos + " categoria= "+categoria +"]";
		}

}

