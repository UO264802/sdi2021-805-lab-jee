package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniovi.services.ProfesorsService;

@Controller
public class ProfesorsController {
	
		@Autowired // Inyectar el servicio
		private ProfesorsService profesorsService;

		@RequestMapping("/profesor/list")
		public String getList() {
			return profesorsService.getProfesors().toString();
		}


}
