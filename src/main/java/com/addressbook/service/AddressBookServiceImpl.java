/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC3
 * Description: Implements CRUD operations using an in-memory ArrayList.
 * Name: Utakarsh Jain
 * Date: 13/11/2026
 */

package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.exception.ContactNotFoundException;
import com.addressbook.mapper.AddressBookMapper;
import com.addressbook.model.AddressBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    private static final Logger logger =
            LoggerFactory.getLogger(AddressBookServiceImpl.class);

    // In-memory collection to store contacts
    private final List<AddressBook> contacts = new ArrayList<>();

    // Generates a unique ID for every new contact
    private int idCounter = 1;

    // Retrieve all contacts
    @Override
    public List<AddressBookDTO> getAllContacts() {

        logger.info("Fetching all contacts");

        // Convert every Model object into a DTO
        return contacts.stream()
                .map(AddressBookMapper::toDTO)
                .toList();
    }

    // Retrieve a contact using its ID
    @Override
    public AddressBookDTO getContactById(int id) {

        logger.info("Fetching contact with ID: {}", id);

        AddressBook contact = findContactById(id);

        return AddressBookMapper.toDTO(contact);
    }

    // Create and store a new contact
    @Override
    public AddressBookDTO createContact(AddressBookDTO dto) {

        logger.info("Creating a new contact");

        // Convert DTO into Model with a generated ID
        AddressBook contact =
                AddressBookMapper.toModel(dto, idCounter++);

        // Store contact in the in-memory List
        contacts.add(contact);

        logger.info("Contact created with ID: {}", contact.getId());

        return AddressBookMapper.toDTO(contact);
    }

    // Update an existing contact
    @Override
    public AddressBookDTO updateContact(int id, AddressBookDTO dto) {

        logger.info("Updating contact with ID: {}", id);

        // Find the existing contact
        AddressBook existingContact = findContactById(id);

        // Update its fields
        existingContact.setFirstName(dto.getFirstName());
        existingContact.setLastName(dto.getLastName());
        existingContact.setPhoneNumber(dto.getPhoneNumber());

        return AddressBookMapper.toDTO(existingContact);
    }

    // Delete a contact using its ID
    @Override
    public String deleteContact(int id) {

        logger.info("Deleting contact with ID: {}", id);

        // Find contact before deleting it
        AddressBook contact = findContactById(id);

        contacts.remove(contact);

        return "Contact deleted successfully with ID: " + id;
    }

    // Find a contact or throw an exception if it does not exist
    private AddressBook findContactById(int id) {

        return contacts.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new ContactNotFoundException(
                                "Contact not found with ID: " + id
                        )
                );
    }
}