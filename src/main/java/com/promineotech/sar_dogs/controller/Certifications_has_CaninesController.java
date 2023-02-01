package com.promineotech.sar_dogs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.sar_dogs.entity.Certification;
import com.promineotech.sar_dogs.entity.Certifications_has_Canines;
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

public interface Certifications_has_CaninesController {
	// @formatter:off
	@Operation(
			summary = "Returns a list of Certifications has Canines",
			description = "Returns a list of Certifications",
			responses = {
					@ApiResponse(
							responseCode = "200", 
							description = "A list of Certifications has Canines is returned", 
							content = @Content(
									mediaType = "application/json", 
									schema = @Schema(implementation = Certifications_has_Canines.class))),
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
	@GetMapping("/readCertifications_has_Canines")
	@ResponseStatus(code = HttpStatus.OK)
	List<Certifications_has_Canines> readCertificationss_has_Canines();
	
	// @formatter:off
	@Operation(
			summary = "Award a Canine a Certificate",
			description = "Returns the created Cert-Has_Canines",
			responses = {
					@ApiResponse(
							responseCode = "201", 
							description = "The created Handler is returned", 
							content = @Content(
									mediaType = "application/json", 
									schema = @Schema(implementation = Certifications_has_Canines.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "A Certifications_has_Canines component was not found with the input critera", 
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occured", 
							content = @Content(
									mediaType = "application/json"))
			},
			parameters = {
					@Parameter(name = "Certifications_idCertifications", required = true, description = "The Certifications_idCertifications is an int"),
					@Parameter(name = "Canines_idCanines", required = true, description = "The Canines_idCanines is an int")

			}
		)
	
	@PostMapping("/createCanineCertification")
	@ResponseStatus(code = HttpStatus.CREATED)
	Certifications_has_Canines createCanineCertification(Long Certifications_idCertifications, Long Canines_idCanines);
	// @formatter:on
	
	// @formatter:off
	@Operation(
			summary = "Delete a Certifications_has_Canines",
			description = "Returns the updated Certifications_has_Canines",
			responses = {
					@ApiResponse(
							responseCode = "200", 
							description = "The Certifications_has_Canines is deleted", 
							content = @Content(
									mediaType = "application/json", 
									schema = @Schema(implementation = Certifications_has_Canines.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "A Certifications_has_Canines component was not found with the input critera", 
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occured", 
							content = @Content(
									mediaType = "application/json"))
			},
			parameters = {
					@Parameter(name = "Certifications_idCertifications", required = true, description = "The Certifications_idCertifications is an int"),
					@Parameter(name = "Canines_idCanines", required = true, description = "The Canines_idCanines is an int")
			}
		)
	
	@DeleteMapping("/deleteCanineCertification")
	@ResponseStatus(code = HttpStatus.OK)
	Certifications_has_Canines deleteCanineCertification(Long Certifications_idCertifications, Long Canines_idCanines);
	// @formatter:on	

	
}
