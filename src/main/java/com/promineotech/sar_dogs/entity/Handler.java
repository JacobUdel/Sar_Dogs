package com.promineotech.sar_dogs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Handler {
	private Long idHandlers;
	private String LastName;
	private String FirstName;
	private String HomeStreet;
	private String HomeStreet2;
	private String HomeCity;
	private String HomeState;
	private Long HomeZip;
	private String MailingStreet;
	private String MailingStreet2;
	private String MailingCity;
	private String MailingState;
	private Long MailingZip;
	private String MobilePhone;
	private String Email;

}

