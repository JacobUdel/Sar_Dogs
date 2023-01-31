package com.promineotech.sar_dogs.dao;

import java.util.List;

import com.promineotech.sar_dogs.entity.Certifications_has_Canines;

public interface Certifications_has_CaninesDao {

	List<Certifications_has_Canines> readCertifications_has_Canines();

	Certifications_has_Canines createCanineCertification(Long certifications_idCertifications, Long canines_idCanines);

}
