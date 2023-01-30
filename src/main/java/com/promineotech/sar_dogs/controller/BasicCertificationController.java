package com.promineotech.sar_dogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.sar_dogs.entity.Certification;
import com.promineotech.sar_dogs.service.CertificationService;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
public class BasicCertificationController implements CertificationController {
	@Autowired
	private CertificationService certificationService;

	@Override
	public List<Certification> readCertifications() {
		// TODO Auto-generated method stub
		return certificationService.readCertifications();
	}

	@Override
	public Certification createCertification(String Agency, String Certification) {
		// TODO Auto-generated method stub
		return certificationService.createCertification(Agency, Certification);
	}

}
