package com.promineotech.sar_dogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.sar_dogs.dao.Certifications_has_CaninesDao;
import com.promineotech.sar_dogs.entity.Certifications_has_Canines;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j

public class BasicCertifications_has_CaninesService implements Certifications_has_CaninesService {
	@Autowired
	private Certifications_has_CaninesDao certifications_has_CaninesDao;

	@Override
	public List<Certifications_has_Canines> readCertifications_has_Canines() {
		// TODO Auto-generated method stub
		return certifications_has_CaninesDao.readCertifications_has_Canines();
	}

}
