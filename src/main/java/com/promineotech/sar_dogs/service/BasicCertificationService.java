package com.promineotech.sar_dogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.sar_dogs.dao.CertificationDao;
import com.promineotech.sar_dogs.entity.Certification;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j

public class BasicCertificationService implements CertificationService {
	@Autowired
	private CertificationDao certificationDao;

	@Override
	public List<Certification> readCertifications() {

		return certificationDao.readCertifications();
	}

}
