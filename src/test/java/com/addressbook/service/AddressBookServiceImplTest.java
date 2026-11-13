/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC2
 * Description: Tests AddressBookServiceImpl business logic using JUnit 5.
 * Name: Utakarsh Jain
 * Date: 13/11/2026
 */

package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookServiceImplTest {

    private AddressBookServiceImpl service;

    // Initialize service before every test
    @BeforeEach
    void setUp() {
        service = new AddressBookServiceImpl();
    }

    // Test retrieving all contacts
    @Test
    void testGetAllContacts() {

        List<AddressBookDTO> contacts = service.getAllContacts();

        assertNotNull(contacts);
        assertTrue(contacts.isEmpty());
    }

    // Test retrieving contact by ID
    @Test
    void testGetContactById() {

        AddressBookDTO response = service.getContactById(1);

        assertNotNull(response);
        assertEquals("Sample", response.getFirstName());
        assertEquals("Contact", response.getLastName());
    }

    // Test creating a contact
    @Test
    void testCreateContact() {

        AddressBookDTO dto = new AddressBookDTO(
                "Utakarsh",
                "Jain",
                "9876543210"
        );

        AddressBookDTO response = service.createContact(dto);

        assertNotNull(response);
        assertEquals("Utakarsh", response.getFirstName());
        assertEquals("Jain", response.getLastName());
        assertEquals("9876543210", response.getPhoneNumber());
    }

    // Test updating a contact
    @Test
    void testUpdateContact() {

        AddressBookDTO dto = new AddressBookDTO(
                "Utakarsh",
                "Jain",
                "9999999999"
        );

        AddressBookDTO response = service.updateContact(1, dto);

        assertNotNull(response);
        assertEquals("9999999999", response.getPhoneNumber());
    }

    // Test deleting a contact
    @Test
    void testDeleteContact() {

        String response = service.deleteContact(1);

        assertTrue(response.contains("successful"));
    }
}