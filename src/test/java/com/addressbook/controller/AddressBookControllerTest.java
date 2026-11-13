
/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC2
 * Description: Tests controller endpoints using a mocked service layer.
 * Name: Utakarsh Jain
 * Date: 13/11/2026
 */

package com.addressbook.controller;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.service.AddressBookService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddressBookControllerTest {

    @Mock
    private AddressBookService addressBookService;

    @InjectMocks
    private AddressBookController controller;

    private AddressBookDTO sampleDTO;

    // Initialize sample contact before every test
    @BeforeEach
    void setUp() {
        sampleDTO = new AddressBookDTO(
                "Utakarsh",
                "Jain",
                "9876543210"
        );
    }

    // Test GET all contacts
    @Test
    void testGetAllContacts() {

        when(addressBookService.getAllContacts())
                .thenReturn(Collections.emptyList());

        ResponseEntity<List<AddressBookDTO>> response =
                controller.getAllContacts();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isEmpty());

        verify(addressBookService).getAllContacts();
    }

    // Test GET contact by ID
    @Test
    void testGetContactById() {

        when(addressBookService.getContactById(1))
                .thenReturn(sampleDTO);

        ResponseEntity<AddressBookDTO> response =
                controller.getContactById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Utakarsh", response.getBody().getFirstName());

        verify(addressBookService).getContactById(1);
    }

    // Test POST create contact
    @Test
    void testCreateContact() {

        when(addressBookService.createContact(sampleDTO))
                .thenReturn(sampleDTO);

        ResponseEntity<AddressBookDTO> response =
                controller.createContact(sampleDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Utakarsh", response.getBody().getFirstName());

        verify(addressBookService).createContact(sampleDTO);
    }

    // Test PUT update contact
    @Test
    void testUpdateContact() {

        when(addressBookService.updateContact(1, sampleDTO))
                .thenReturn(sampleDTO);

        ResponseEntity<AddressBookDTO> response =
                controller.updateContact(1, sampleDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("9876543210", response.getBody().getPhoneNumber());

        verify(addressBookService).updateContact(1, sampleDTO);
    }

    // Test DELETE contact
    @Test
    void testDeleteContact() {

        when(addressBookService.deleteContact(1))
                .thenReturn("DELETE request successful for ID: 1");

        ResponseEntity<String> response =
                controller.deleteContact(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("successful"));

        verify(addressBookService).deleteContact(1);
    }
}
