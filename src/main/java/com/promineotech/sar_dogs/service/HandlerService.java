package com.promineotech.sar_dogs.service;

import java.util.List;

import com.promineotech.sar_dogs.entity.Handler;

public interface HandlerService {

	List<Handler> readHandlerByName(String lastName, String firstName);

	List<Handler> readHandlers();

	Handler createHandler(String lastName, String firstName, String homeStreet, String homeStreet2, String homeCity,
			String homeState, int homeZip, String mailingStreet, String mailingStreet2, String mailingCity,
			String mailingState, int mailingZip, String mobilePhone, String email);

}
