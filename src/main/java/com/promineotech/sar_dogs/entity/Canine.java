package com.promineotech.sar_dogs.entity;

import java.sql.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Canine {
	private Long idCanines;
	private String Name;
	private String Breed;
	private Sex Sex;
	private Date Birthdate;
	private Long Handlers_idHandlers;


}

