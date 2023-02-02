package com.promineotech.sar_dogs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.sar_dogs.dao.HandlerDao;
import com.promineotech.sar_dogs.entity.Handler;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j

public class BasicHandlerService implements HandlerService {
	@Autowired
	private HandlerDao handlerDao;

	@Override
	public List<Handler> readHandlerByName(String lastName, String firstName) {
		log.info("fetchHandler was called with lastName={} and firstName={}", lastName, firstName);
		return handlerDao.readHandlerByName(lastName, firstName);
	}

	@Override
	public List<Handler> readHandlers() {
		// TODO Auto-generated method stub
		return handlerDao.readHandlers();
	}

	@Override
	public Handler createHandler(String lastName, String firstName, String homeStreet, String homeStreet2,
			String homeCity, String homeState, Long homeZip, String mailingStreet, String mailingStreet2,
			String mailingCity, String mailingState, Long mailingZip, String mobilePhone, String email) {
		// TODO Auto-generated method stub
		return handlerDao.createHandler(lastName, firstName, homeStreet, homeStreet2, homeCity, homeState, homeZip, mailingStreet,
				mailingStreet2, mailingCity, mailingState, mailingZip, mobilePhone, email);
	}

	@Override
	public Handler updateHandlerPhone(Long idHandlers, String mobilePhone) {

		return handlerDao.updateHandlerPhone(idHandlers, mobilePhone);
	}

	@Override
	public Optional<Handler> deleteHandler(Long idHandlers) {

		return handlerDao.deleteHandler(idHandlers);
	}

}
