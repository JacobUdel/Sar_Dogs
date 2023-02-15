package com.promineotech.sar_dogs.controller;

import java.sql.Date;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.sar_dogs.entity.Canine;
import com.promineotech.sar_dogs.entity.Handler;
import com.promineotech.sar_dogs.entity.Sex;
import com.promineotech.sar_dogs.service.CanineService;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
public class BasicCanineController implements CanineController {

	@Autowired
	private CanineService canineService;
	
	@Override
	public List<Canine> readCanineByHandler(int handlerId) {
		log.debug("List canines by Handler ID = {}", handlerId);
		return canineService.readCanineByHandler(handlerId);
	}

	@Override
	public List<Canine> readCanines() {
		return canineService.readCanines();
	}

	@Override
	public Canine createCanine(String Name, String Breed, Sex Sex, Date Birthdate, Long Handlers_idHandlers) {

		return canineService.createCanine(Name, Breed, Sex, Birthdate, Handlers_idHandlers);
	}

	@Override
	public Canine deleteCanine(Long idCanines) {
		
		return canineService.deleteCanine(idCanines);
	}

}
