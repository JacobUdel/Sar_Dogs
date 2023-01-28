package com.promineotech.sar_dogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.promineotech.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})

public class sar_dogs {

	public static void main(String[] args) {
		SpringApplication.run(sar_dogs.class, args);

	}

}
