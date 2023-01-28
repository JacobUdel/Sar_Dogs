package com.promineotech.sar_dogs.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.promineotech.sar_dogs.controller.support.fetchHandlerSupport;
import com.promineotech.sar_dogs.entity.Handler;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:/flyway/migrations/V1.0__SAR_Dog_Schema.sql", "classpath:/flyway/migrations/V1.1__values.sql"}, config = @SqlConfig(encoding = "utf-8"))

class fetchHandler extends fetchHandlerSupport {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	@Test
//	void testDb() {
//		int numRows = JdbcTestUtils.countRowsInTable(jdbcTemplate, "Handlers");
//		System.out.println("Rows=" + numRows);
//	}
//	
//	@Disabled
	
	@Test
	void testThatAHandlerIsReturnedWhenAFirstAndLastNameAreProvided() {
		//System.out.println(getBaseUri());
		
		// Given a valid Lastname, Firstname, and URI
		String lastName = "Ableton";
		String firstName = "Abe";
		String uri = String.format("%s?lastName=%s&firstName=%s", getBaseUri(), lastName, firstName);
		//System.out.println(uri);
		
		// When a connection is made to the URI
		ResponseEntity<List<Handler>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		
		// Then a success (OK = 200) status code is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		// AND the actual list returned is the same as the expected list
		List<Handler> expected = buildExpected();
		assertThat(response.getBody()).isEqualTo(expected);
	}



}
