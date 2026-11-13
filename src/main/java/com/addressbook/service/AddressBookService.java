/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC2
 * Description: Defines service operations for managing AddressBook contacts.
 * Name: Utakarsh Jain
 * Date: 13/11/2026
 */

package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;

import java.util.List;

public interface AddressBookService {

    // Retrieve all contacts
    List<AddressBookDTO> getAllContacts();

    // Retrieve a contact using its ID
    AddressBookDTO getContactById(int id);

    // Create a new contact
    AddressBookDTO createContact(AddressBookDTO dto);

    // Update an existing contact
    AddressBookDTO updateContact(int id, AddressBookDTO dto);

    // Delete a contact using its ID
    String deleteContact(int id);
}