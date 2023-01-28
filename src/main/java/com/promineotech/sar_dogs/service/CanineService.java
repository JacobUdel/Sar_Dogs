package com.promineotech.sar_dogs.service;

import java.util.List;

import com.promineotech.sar_dogs.entity.Canine;
import com.promineotech.sar_dogs.entity.Handler;

public interface CanineService {

	List<Canine> readCanineByHandler(int handlerId);

	List<Canine> readCanines();

}
