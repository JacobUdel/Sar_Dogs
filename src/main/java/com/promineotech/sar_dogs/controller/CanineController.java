package com.promineotech.sar_dogs.controller;

import java.sql.Date;
//import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.sar_dogs.entity.Canine;
import com.promineotech.sar_dogs.entity.Handler;

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
public interface CanineController {
	
	// @formatter:off
	@Operation(
			summary = "Returns a list of Canines",
			description = "Returns a list of Canines given a Handler ID",
			responses = {
					@ApiResponse(
							responseCode = "200", 
							description = "A list of Canines is returned", 
							content = @Content(
									mediaType = "application/json", 
									schema = @Schema(implementation = Canine.class))),
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
					@Parameter(name = "handlerId", allowEmptyValue = false, description = "Handler ID")
			}
		)
	// @formatter:on
	@GetMapping("/readCaninesByHandler")
	@ResponseStatus(code = HttpStatus.OK)
	List<Canine> readCanineByHandler(@RequestParam(required = false) int handlerId);
	
	// @formatter:off
	@Operation(
			summary = "Returns a list of Canines",
			description = "Returns a list of Handlers",
			responses = {
					@ApiResponse(
							responseCode = "200", 
							description = "A list of Canines is returned", 
							content = @Content(
									mediaType = "application/json", 
									schema = @Schema(implementation = Canine.class))),
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
	@GetMapping("/readCanines")
	@ResponseStatus(code = HttpStatus.OK)
	List<Canine> readCanines();
	
	
	// @formatter:off
	@Operation(
			summary = "Create a new Canine",
			description = "Returns the created Canine",
			responses = {
					@ApiResponse(
							responseCode = "201", 
							description = "The created Canine is returned", 
							content = @Content(
									mediaType = "application/json", 
									schema = @Schema(implementation = Canine.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "A Canine component was not found with the input critera", 
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occured", 
							content = @Content(
									mediaType = "application/json"))
			},
			parameters = {
					@Parameter(name = "Name", required = true, description = "The Name is a String"),
					@Parameter(name = "Breed", required = true, description = "The Breed is a String"),
					@Parameter(name = "Sex", required = true, description = "The Sex is an int"),
					@Parameter(name = "Birthdate", required = true, description = "The Birthdate is a DATE"),
					@Parameter(name = "Handlers_idHandlers", required = true, description = "The Handlers_idHandlers is a Long")

			}
		)
	
	@PostMapping("/createCanine")
	@ResponseStatus(code = HttpStatus.CREATED)
	Canine createCanine(String Name, String Breed, int Sex, Date Birthdate, Long Handlers_idHandlers);
	// @formatter:on
	
	
}