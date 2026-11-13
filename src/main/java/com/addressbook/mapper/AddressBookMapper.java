/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC1
 * Description: Converts AddressBookDTO objects into Model objects and vice versa.
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

        return new AddressBookDTO(
                model.getFirstName(),
                model.getLastName(),
                model.getPhoneNumber()
        );
    }
}