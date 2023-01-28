package com.promineotech.sar_dogs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.sar_dogs.entity.Handler;
import com.promineotech.sar_dogs.entity.HandlerRequest;
import com.promineotech.sar_dogs.service.HandlerService;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j

public class BasicHandlerController implements HandlerController {

	@Autowired
	
	private HandlerService handlerService;
	
	@Override
	public List<Handler> readHandlerByName(String lastName, String firstName) {
		log.debug("LastName={}, FirstName={}", lastName, firstName);
		return handlerService.readHandlerByName(lastName, firstName);
	}

	@Override
	public List<Handler> readHandlers() {
		// TODO Auto-generated method stub
		return handlerService.readHandlers();
	}

	@Override
	public Handler createHandler(String LastName, String FirstName, String HomeStreet, String HomeStreet2,
			String HomeCity, String HomeState, int HomeZip, String MailingStreet, String MailingStreet2,
			String MailingCity, String MailingState, int MailingZip, String MobilePhone, String Email) {

		return handlerService.createHandler(LastName, FirstName, HomeStreet, HomeStreet2, HomeCity, HomeState, 
				HomeZip, MailingStreet, MailingStreet2, MailingCity, MailingState, MailingZip, MobilePhone, Email);
	}



}
