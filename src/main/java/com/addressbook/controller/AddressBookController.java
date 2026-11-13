
/*
 * Project Name: Address Book Application
 * Use Case: Section 1 - UC2
 *
 * Description:
 * This controller demonstrates REST API operations using
 * different HTTP methods such as GET, POST, PUT and DELETE.
 *
 * It receives HTTP requests from clients, processes the
 * request data and returns JSON responses using ResponseEntity.
 *
 * At this stage, the controller focuses on REST API connectivity
 * and request-response communication without database persistence.
 *
 * Name: Utakarsh Jain
 * Date: 13/11/2026
 */

package com.addressbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    // Logger for recording important API events.
    private static final Logger logger =
            LoggerFactory.getLogger(AddressBookController.class);

    /*
     * GET API:
     * Retrieves all contacts.
     * Endpoint: GET /addressbook/
     */
    @GetMapping({"", "/"})
    public ResponseEntity<Map<String, Object>> getAllContacts() {

        logger.info("GET request received to fetch all contacts");

        Map<String, Object> response = Map.of(
                "message", "GET Request Successful"
        );

        return ResponseEntity.ok(response);
    }

    /*
     * GET API:
     * Retrieves a contact using its ID.
     * Endpoint: GET /addressbook/get/{id}
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<Map<String, Object>> getContactById(
            @PathVariable int id) {

        logger.info("GET request received for contact ID: {}", id);

        Map<String, Object> response = Map.of(
                "message", "GET Contact Successful",
                "id", id
        );

        return ResponseEntity.ok(response);
    }

    /*
     * POST API:
     * Receives contact information from the client.
     * Endpoint: POST /addressbook/create
     */
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createContact(
            @RequestBody Map<String, Object> contact) {

        logger.info("POST request received to create contact");

        Map<String, Object> response = Map.of(
                "message", "POST Request Successful",
                "contact", contact
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /*
     * PUT API:
     * Receives updated contact information for a given ID.
     * Endpoint: PUT /addressbook/update/{id}
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateContact(
            @PathVariable int id,
            @RequestBody Map<String, Object> contact) {

        logger.info("PUT request received for contact ID: {}", id);

        Map<String, Object> response = Map.of(
                "message", "PUT Request Successful",
                "id", id,
                "updatedContact", contact
        );

        return ResponseEntity.ok(response);
    }

    /*
     * DELETE API:
     * Demonstrates deleting a contact using its ID.
     * Endpoint: DELETE /addressbook/delete/{id}
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteContact(
            @PathVariable int id) {

        logger.info("DELETE request received for contact ID: {}", id);

        Map<String, Object> response = Map.of(
                "message", "DELETE Request Successful",
                "id", id
        );

        return ResponseEntity.ok(response);
    }
}
