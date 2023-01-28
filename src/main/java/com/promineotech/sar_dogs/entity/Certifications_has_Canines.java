package com.promineotech.sar_dogs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Certifications_has_Canines {
	private Long Certifications_idCertifications;
	private Long Canines_idCanines;

}
