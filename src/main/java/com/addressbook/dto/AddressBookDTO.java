/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC1
 * Description: Transfers contact information between the client and controller.
 * Name: Utakarsh Jain
 * Date: 13/11/2026
 */

package com.addressbook.dto;

public class AddressBookDTO {

    // Contact information received from the client
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Default constructor
    public AddressBookDTO() {
    }

    // Parameterized constructor
    public AddressBookDTO(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}