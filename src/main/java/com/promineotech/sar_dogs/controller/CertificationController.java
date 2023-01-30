package com.promineotech.sar_dogs.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.sar_dogs.entity.Canine;
import com.promineotech.sar_dogs.entity.Certification;
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
public interface CertificationController {
	
	// @formatter:off
	@Operation(
			summary = "Returns a list of Certifications",
			description = "Returns a list of Certifications",
			responses = {
					@ApiResponse(
							responseCode = "200", 
							description = "A list of Certifications is returned", 
							content = @Content(
									mediaType = "application/json", 
									schema = @Schema(implementation = Certification.class))),
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
	@GetMapping("/readCertifications")
	@ResponseStatus(code = HttpStatus.OK)
	List<Certification> readCertifications();
	
	// @formatter:off
	@Operation(
			summary = "Create a new Certification",
			description = "Returns the created Certification",
			responses = {
					@ApiResponse(
							responseCode = "201", 
							description = "The created Certification is returned", 
							content = @Content(
									mediaType = "application/json", 
									schema = @Schema(implementation = Certification.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "A Certification component was not found with the input critera", 
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occured", 
							content = @Content(
									mediaType = "application/json"))
			},
			parameters = {
					@Parameter(name = "Agency", required = true, description = "The Agency is a String"),
					@Parameter(name = "Certification", required = true, description = "The Certification is a String")

			}
		)
	
		@PostMapping("/createCertification")
		@ResponseStatus(code = HttpStatus.CREATED)
		Certification createCertification(String Agency, String Certification);
		// @formatter:on	
}
