package com.promineotech.sar_dogs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


import com.promineotech.sar_dogs.entity.Handler;
import com.promineotech.sar_dogs.entity.HandlerRequest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/sar_dogs")
@OpenAPIDefinition(info = @Info(title = "Sar Dogs Service"), servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface HandlerController {
	
	// @formatter:off
	@Operation(
			summary = "Returns a list of Handlers",
			description = "Returns a list of Handlers given a lastname and firstname",
			responses = {
					@ApiResponse(
							responseCode = "200", 
							description = "A list of Handlers is returned", 
							content = @Content(
									mediaType = "application/json", 
									schema = @Schema(implementation = Handler.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "No Handlers were found with the input critera", 
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occured", 
							content = @Content(
									mediaType = "application/json"))
			},
			parameters = {
					@Parameter(name = "lastName", allowEmptyValue = false, required = false, description = "Last name"),
					@Parameter(name = "firstName", allowEmptyValue = false, description = "First name")
			}
		)
	// @formatter:on
	@GetMapping("/readHandlerByName")
	@ResponseStatus(code = HttpStatus.OK)
	List<Handler> readHandlerByName(@RequestParam(required = false) String lastName, @RequestParam(required = false) String firstName);
	
	// @formatter:off
	@Operation(
			summary = "Returns a list of Handlers",
			description = "Returns a list of Handlers",
			responses = {
					@ApiResponse(
							responseCode = "200", 
							description = "A list of Handlers is returned", 
							content = @Content(
									mediaType = "application/json", 
									schema = @Schema(implementation = Handler.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "No Handlers were found with the input critera", 
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occured", 
							content = @Content(
									mediaType = "application/json"))
			}
		)
	// @formatter:on
	@GetMapping("/readHandlers")
	@ResponseStatus(code = HttpStatus.OK)
	List<Handler> readHandlers();
	
	
	// @formatter:off
	@Operation(
			summary = "Create a new Handler",
			description = "Returns the created Handler",
			responses = {
					@ApiResponse(
							responseCode = "201", 
							description = "The created Handler is returned", 
							content = @Content(
									mediaType = "application/json", 
									schema = @Schema(implementation = Handler.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "A Handler component was not found with the input critera", 
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occured", 
							content = @Content(
									mediaType = "application/json"))
			},
			parameters = {
					@Parameter(name = "LastName", required = true, description = "The LastName is a String"),
					@Parameter(name = "FirstName", required = true, description = "The FirstName is a String"),
					@Parameter(name = "HomeAddress", required = true, description = "The HomeAddress is a String"),
					@Parameter(name = "HomeAddress2", required = true, description = "The HomeAddress2 is a String"),
					@Parameter(name = "HomeCity", required = true, description = "The HomeCity is a String"),
					@Parameter(name = "HomeState", required = true, description = "The HomeState is a String"),
					@Parameter(name = "HomeZip", required = true, description = "The HomeZip is an int"),
					@Parameter(name = "MailingAddress", required = true, description = "The MailingAddress is a String"),
					@Parameter(name = "MailingAddress2", required = true, description = "The MailingAddress2 is a String"),
					@Parameter(name = "MailingCity", required = true, description = "The MailingCity is a String"),
					@Parameter(name = "MailingState", required = true, description = "The Mailingtate is a String"),
					@Parameter(name = "MailingZip", required = true, description = "The MailingZip is an int"),
					@Parameter(name = "MobilePhone", required = true, description = "The MobilePhone is a String"),
					@Parameter(name = "Email", required = true, description = "The Email is a String")
			}
		)
	
	@PostMapping("/createHandler")
	@ResponseStatus(code = HttpStatus.CREATED)
	Handler createHandler(String LastName, String FirstName, String HomeAddress, String HomeAddress2, String HomeCity, String HomeState, int HomeZip,
			String MailingStreet, String MailingStreet2, String MailingCity, String MailingState, int MailingZip, String MobilePhone, String Email);
	// @formatter:on
	
}
