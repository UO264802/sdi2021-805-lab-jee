package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.uniovi.entities.Profesor;

@Service
public class ProfesorsService {

	List<Profesor> profesorsRepository = new ArrayList<Profesor>();

	@PostConstruct
	public void init() {
		profesorsRepository.add(new Profesor("1", "Juan", "Garcia", "A"));
		profesorsRepository.add(new Profesor("2", "Juani", "Lopez", "A"));
	}

	public List<Profesor> getProfesors() {
		return profesorsRepository;
	}

	public Profesor getProfesor(String dni) {
		for (Profesor p : profesorsRepository)
			if (p.dni == dni)
				return p;
		return null;
	}

	public void addProfesor(Profesor profesor) {
		profesorsRepository.add(profesor);
	}

	public void deleteProfesor(String dni) {
		for (Profesor p : profesorsRepository)
			if (p.dni == dni)
				profesorsRepository.remove(p);
	}
}
