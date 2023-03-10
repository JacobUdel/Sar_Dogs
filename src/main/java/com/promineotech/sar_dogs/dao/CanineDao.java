package com.promineotech.sar_dogs.dao;

import java.sql.Date;
// import java.util.Date;
import java.util.List;

import com.promineotech.sar_dogs.entity.Canine;
import com.promineotech.sar_dogs.entity.Sex;

public interface CanineDao {

	List<Canine> readCanineByHandler(int handlerId);

	List<Canine> readCanines();

	Canine createCanine(String name, String breed, Sex sex, Date birthdate, Long handlers_idHandlers);

	Canine deleteCanine(Long idCanines);

}
