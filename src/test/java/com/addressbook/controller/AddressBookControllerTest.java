
/*
 * Project Name: Address Book Application
 * Use Case: Section 1 - UC2
 *
 * Description:
 * This test class verifies all REST controller operations
 * including GET, GET by ID, POST, PUT and DELETE.
 *
 * It checks the HTTP status codes and JSON response data
 * returned by the AddressBookController methods.
 *
 * Name: Utakarsh Jain
 * Date: 13/11/2026
 */

package com.addressbook.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookControllerTest {

    // Controller instance used for unit testing.
    private AddressBookController addressBookController;

    /*
     * Initializes the controller before every test case.
     */
    @BeforeEach
    void setUp() {
        addressBookController = new AddressBookController();
    }

    /*
     * Test Case 1:
     * Verifies GET request for retrieving all contacts.
     */
    @Test
    void testGetAllContacts() {

        ResponseEntity<Map<String, Object>> response =
                addressBookController.getAllContacts();

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(
                "GET Request Successful",
                response.getBody().get("message")
        );
    }

    /*
     * Test Case 2:
     * Verifies GET request for retrieving a contact by ID.
     */
    @Test
    void testGetContactById() {

        ResponseEntity<Map<String, Object>> response =
                addressBookController.getContactById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(1, response.getBody().get("id"));

        assertEquals(
                "GET Contact Successful",
                response.getBody().get("message")
        );
    }

    /*
     * Test Case 3:
     * Verifies POST request for creating a contact.
     */
    @Test
    void testCreateContact() {

        Map<String, Object> contact = Map.of(
                "firstName", "Utakarsh",
                "lastName", "Jain",
                "phoneNumber", "9876543210"
        );

        ResponseEntity<Map<String, Object>> response =
                addressBookController.createContact(contact);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        assertEquals(
                "POST Request Successful",
                response.getBody().get("message")
        );

        assertEquals(
                contact,
                response.getBody().get("contact")
        );
    }

    /*
     * Test Case 4:
     * Verifies PUT request for updating a contact.
     */
    @Test
    void testUpdateContact() {

        Map<String, Object> updatedContact = Map.of(
                "firstName", "Utakarsh",
                "lastName", "Jain",
                "phoneNumber", "9999999999"
        );

        ResponseEntity<Map<String, Object>> response =
                addressBookController.updateContact(1, updatedContact);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(1, response.getBody().get("id"));

        assertEquals(
                updatedContact,
                response.getBody().get("updatedContact")
        );

        assertEquals(
                "PUT Request Successful",
                response.getBody().get("message")
        );
    }

    /*
     * Test Case 5:
     * Verifies DELETE request for deleting a contact by ID.
     */
    @Test
    void testDeleteContact() {

        ResponseEntity<Map<String, Object>> response =
                addressBookController.deleteContact(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(1, response.getBody().get("id"));

        assertEquals(
                "DELETE Request Successful",
                response.getBody().get("message")
        );
    }
}
