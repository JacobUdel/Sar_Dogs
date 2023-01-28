package com.promineotech.sar_dogs.entity;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;



import lombok.Data;

@Data
public class HandlerRequest {
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")
  private String LastName;
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")	
  private String FirstName;
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")
  private String HomeStreet;
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")	
  private String HomeStreet2;
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")
  private String HomeCity;
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")	
  private String HomeState;
	@Positive
	@Min(0)
	@Max(99999)
  private int HomeZip;
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")
  private String MailingStreet;
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")
  private String MailingStreet2;
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")
  private String MailingCity;
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")	
  private String MailingState;
	@Positive
	@Min(0)
	@Max(99999)
  private int MailingZip;
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")
  private String MobilePhone;
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")	
  private String Email;

}

