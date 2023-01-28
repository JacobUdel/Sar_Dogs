package com.promineotech.sar_dogs.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import lombok.Getter;

public class baseTest {
	@LocalServerPort 
	private int serverPort; 
	
	@Autowired
	@Getter 
	private TestRestTemplate restTemplate;
	
	protected String getBaseUri() {
		return String.format("http://localhost:%d/sar_dogs", serverPort);
	}
}
