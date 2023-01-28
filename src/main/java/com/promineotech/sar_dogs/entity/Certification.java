package com.promineotech.sar_dogs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Certification {
	private Long idCertifications;
	private String Agency;
	private String Certification;

}
