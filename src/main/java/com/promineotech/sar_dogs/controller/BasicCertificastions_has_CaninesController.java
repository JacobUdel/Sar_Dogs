package com.promineotech.sar_dogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.sar_dogs.entity.Certifications_has_Canines;

import com.promineotech.sar_dogs.service.Certifications_has_CaninesService;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j

public class BasicCertificastions_has_CaninesController implements Certifications_has_CaninesController {
	@Autowired
	private Certifications_has_CaninesService certifications_has_CaninesService;
	@Override
	public List<Certifications_has_Canines> readCertificationss_has_Canines() {

		return certifications_has_CaninesService.readCertifications_has_Canines();
	}
	@Override
	public Certifications_has_Canines createCanineCertification(Long Certifications_idCertifications, Long Canines_idCanines) {
		
		return certifications_has_CaninesService.createCanineCertification(Certifications_idCertifications, Canines_idCanines);
	}
	@Override
	public Certifications_has_Canines deleteCanineCertification(Long Certifications_idCertifications,
			Long Canines_idCanines) {

		return certifications_has_CaninesService.deleteCanineCertification(Certifications_idCertifications, Canines_idCanines);
	}

}
