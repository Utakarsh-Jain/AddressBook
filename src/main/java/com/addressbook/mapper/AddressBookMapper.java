/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC3
 * Description: Converts AddressBook Model objects into DTOs and DTOs into Models.
 * Name: Utakarsh Jain
 * Date: 13/11/2026
 */

package com.addressbook.mapper;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;

public class AddressBookMapper {

    // Convert DTO into Model
    public static AddressBook toModel(AddressBookDTO dto, int id) {

        return new AddressBook(
                id,
                dto.getFirstName(),
                dto.getLastName(),
                dto.getPhoneNumber()
        );
    }

    // Convert Model into DTO
    public static AddressBookDTO toDTO(AddressBook model) {

        AddressBookDTO dto = new AddressBookDTO(
                model.getFirstName(),
                model.getLastName(),
                model.getPhoneNumber()
        );

        // Include contact ID in API response
        dto.setId(model.getId());

        return dto;
    }
}