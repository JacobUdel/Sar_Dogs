package com.promineotech.sar_dogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.sar_dogs.dao.CanineDao;
import com.promineotech.sar_dogs.entity.Handler;
import com.promineotech.sar_dogs.entity.Canine;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class BasicCanineService implements CanineService {

	@Autowired
	private CanineDao canineDao;
	
	@Override
	public List<Canine> readCanineByHandler(int handlerId) {

		return canineDao.readCanineByHandler(handlerId);
	}

	@Override
	public List<Canine> readCanines() {

		return canineDao.readCanines();
	}

}
