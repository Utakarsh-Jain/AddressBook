/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC1
 * Description: Tests controller operations using DTO and Model.
 * Name: Utakarsh Jain
 * Date: 13/11/2026
 */

package com.addressbook.controller;

import com.addressbook.dto.AddressBookDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookControllerTest {

    private AddressBookController controller;

    // Initialize controller before every test
    @BeforeEach
    void setUp() {
        controller = new AddressBookController();
    }

    // Test GET all contacts
    @Test
    void testGetAllContacts() {

        ResponseEntity<List<AddressBookDTO>> response =
                controller.getAllContacts();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().isEmpty());
    }

    // Test GET contact by ID
    @Test
    void testGetContactById() {

        ResponseEntity<AddressBookDTO> response =
                controller.getContactById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Sample", response.getBody().getFirstName());
    }

    // Test POST create contact
    @Test
    void testCreateContact() {

        AddressBookDTO dto = new AddressBookDTO(
                "Utakarsh",
                "Jain",
                "9876543210"
        );

        ResponseEntity<AddressBookDTO> response =
                controller.createContact(dto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Utakarsh", response.getBody().getFirstName());
    }

    // Test PUT update contact
    @Test
    void testUpdateContact() {

        AddressBookDTO dto = new AddressBookDTO(
                "Utakarsh",
                "Jain",
                "9999999999"
        );

        ResponseEntity<AddressBookDTO> response =
                controller.updateContact(1, dto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("9999999999", response.getBody().getPhoneNumber());
    }

    // Test DELETE contact
    @Test
    void testDeleteContact() {

        ResponseEntity<String> response =
                controller.deleteContact(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("successful"));
    }
}