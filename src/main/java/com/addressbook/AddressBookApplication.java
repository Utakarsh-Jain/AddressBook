
/*
 * Project Name: Address Book Application
 * Use Case: Section 1 - UC1
 * Description:
 * This class is the main entry point of the Address Book Spring Boot
 * application. It initializes the Spring application context and
 * starts the embedded web server using Spring Boot.
 *
 * Name: Utakarsh Jain
 * Date: 13/11/2026
 */

package com.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication enables:
 * 1. Auto Configuration
 * 2. Component Scanning
 * 3. Spring Boot Configuration
 */
@SpringBootApplication
public class AddressBookApplication {

	/*
	 * Main method:
	 * Starts the Address Book application.
	 */
	public static void main(String[] args) {

		SpringApplication.run(AddressBookApplication.class, args);
	}
}
