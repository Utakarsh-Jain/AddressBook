/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC3
 * Description: Tests in-memory CRUD operations of the AddressBook service.
 * Name: Utakarsh Jain
 * Date: 13/11/2026
 */

package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.exception.ContactNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookServiceImplTest {

    private AddressBookServiceImpl service;

    // Initialize a fresh service before every test
    @BeforeEach
    void setUp() {
        service = new AddressBookServiceImpl();
    }

    // Test retrieving all contacts when List is empty
    @Test
    void testGetAllContactsWhenEmpty() {

        List<AddressBookDTO> contacts = service.getAllContacts();

        assertNotNull(contacts);
        assertTrue(contacts.isEmpty());
    }

    // Test creating a new contact
    @Test
    void testCreateContact() {

        AddressBookDTO dto = new AddressBookDTO(
                "Utakarsh",
                "Jain",
                "9876543210"
        );

        AddressBookDTO response = service.createContact(dto);

        assertNotNull(response);
        assertEquals(1, response.getId());
        assertEquals("Utakarsh", response.getFirstName());
        assertEquals("Jain", response.getLastName());
        assertEquals("9876543210", response.getPhoneNumber());
    }

    // Test retrieving all stored contacts
    @Test
    void testGetAllContacts() {

        service.createContact(new AddressBookDTO(
                "Utakarsh", "Jain", "9876543210"
        ));

        service.createContact(new AddressBookDTO(
                "Rahul", "Sharma", "9876500000"
        ));

        List<AddressBookDTO> contacts = service.getAllContacts();

        assertEquals(2, contacts.size());
        assertEquals("Utakarsh", contacts.get(0).getFirstName());
        assertEquals("Rahul", contacts.get(1).getFirstName());
    }

    // Test retrieving a contact using ID
    @Test
    void testGetContactById() {

        AddressBookDTO created = service.createContact(
                new AddressBookDTO(
                        "Utakarsh", "Jain", "9876543210"
                )
        );

        AddressBookDTO response =
                service.getContactById(created.getId());

        assertEquals(created.getId(), response.getId());
        assertEquals("Utakarsh", response.getFirstName());
    }

    // Test updating an existing contact
    @Test
    void testUpdateContact() {

        AddressBookDTO created = service.createContact(
                new AddressBookDTO(
                        "Utakarsh", "Jain", "9876543210"
                )
        );

        AddressBookDTO updatedDTO = new AddressBookDTO(
                "Utakarsh",
                "Jain",
                "9999999999"
        );

        AddressBookDTO response =
                service.updateContact(created.getId(), updatedDTO);

        assertEquals("9999999999", response.getPhoneNumber());
        assertEquals("Utakarsh", response.getFirstName());
    }

    // Test deleting an existing contact
    @Test
    void testDeleteContact() {

        AddressBookDTO created = service.createContact(
                new AddressBookDTO(
                        "Utakarsh", "Jain", "9876543210"
                )
        );

        String response = service.deleteContact(created.getId());

        assertTrue(response.contains("deleted successfully"));
        assertTrue(service.getAllContacts().isEmpty());
    }

    // Test searching for a contact that does not exist
    @Test
    void testGetContactByInvalidId() {

        assertThrows(
                ContactNotFoundException.class,
                () -> service.getContactById(100)
        );
    }

    // Test updating a contact that does not exist
    @Test
    void testUpdateContactWithInvalidId() {

        AddressBookDTO dto = new AddressBookDTO(
                "Utakarsh", "Jain", "9876543210"
        );

        assertThrows(
                ContactNotFoundException.class,
                () -> service.updateContact(100, dto)
        );
    }

    // Test deleting a contact that does not exist
    @Test
    void testDeleteContactWithInvalidId() {

        assertThrows(
                ContactNotFoundException.class,
                () -> service.deleteContact(100)
        );
    }
}