package com.promineotech.sar_dogs.service;

import java.util.List;

import com.promineotech.sar_dogs.entity.Certifications_has_Canines;


public interface Certifications_has_CaninesService {

	List<Certifications_has_Canines> readCertifications_has_Canines();

	Certifications_has_Canines createCanineCertification(Long certifications_idCertifications, Long canines_idCanines);

	Certifications_has_Canines deleteCanineCertification(Long certifications_idCertifications, Long canines_idCanines);

}
