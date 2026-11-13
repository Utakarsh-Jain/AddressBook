/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC3
 * Description: Defines operations for managing contacts in the Address Book.
 * Name: Utakarsh Jain
 * Date: 13/11/2026
 */

package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;

import java.util.List;

public interface AddressBookService {

    // Retrieve all contacts
    List<AddressBookDTO> getAllContacts();

    // Retrieve a contact using ID
    AddressBookDTO getContactById(int id);

    // Add a new contact
    AddressBookDTO createContact(AddressBookDTO dto);

    // Update an existing contact
    AddressBookDTO updateContact(int id, AddressBookDTO dto);

    // Delete a contact using ID
    String deleteContact(int id);
}