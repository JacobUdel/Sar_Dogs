package com.promineotech.sar_dogs.dao;

import java.util.List;

import com.promineotech.sar_dogs.entity.Canine;

public interface CanineDao {

	List<Canine> readCanineByHandler(int handlerId);

	List<Canine> readCanines();

}
