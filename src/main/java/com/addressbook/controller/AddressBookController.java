/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC1
 * Description: Handles REST requests using AddressBook DTO and Model.
 * Name: Utakarsh Jain
 * Date: 13/11/2026
 */

package com.addressbook.controller;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.mapper.AddressBookMapper;
import com.addressbook.model.AddressBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    // Logger for tracking API operations
    private static final Logger logger =
            LoggerFactory.getLogger(AddressBookController.class);

    // Temporary ID counter; persistent storage comes in UC3
    private int idCounter = 1;

    // GET: Retrieve all contacts
    @GetMapping({"", "/"})
    public ResponseEntity<List<AddressBookDTO>> getAllContacts() {

        logger.info("GET request received for all contacts");

        // No in-memory storage is implemented in this UC
        return ResponseEntity.ok(new ArrayList<>());
    }

    // GET: Retrieve contact using ID
    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookDTO> getContactById(@PathVariable int id) {

        logger.info("GET request received for contact ID: {}", id);

        // Demonstration model for this use case
        AddressBook model = new AddressBook(
                id,
                "Sample",
                "Contact",
                "9876543210"
        );

        AddressBookDTO dto = AddressBookMapper.toDTO(model);

        return ResponseEntity.ok(dto);
    }

    // POST: Create a contact using DTO
    @PostMapping("/create")
    public ResponseEntity<AddressBookDTO> createContact(
            @RequestBody AddressBookDTO dto) {

        logger.info("POST request received to create contact");

        // Convert incoming DTO into Model
        AddressBook model = AddressBookMapper.toModel(dto, idCounter++);

        // Convert Model back into DTO for API response
        AddressBookDTO responseDTO = AddressBookMapper.toDTO(model);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    // PUT: Update contact using ID
    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBookDTO> updateContact(
            @PathVariable int id,
            @RequestBody AddressBookDTO dto) {

        logger.info("PUT request received for contact ID: {}", id);

        // Create updated Model from the incoming DTO
        AddressBook model = AddressBookMapper.toModel(dto, id);

        AddressBookDTO responseDTO = AddressBookMapper.toDTO(model);

        return ResponseEntity.ok(responseDTO);
    }

    // DELETE: Demonstrate delete request
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {

        logger.info("DELETE request received for contact ID: {}", id);

        return ResponseEntity.ok(
                "DELETE request successful for ID: " + id
        );
    }
}