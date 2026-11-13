/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC3
 * Description: Transfers contact details and contact ID between API layers.
 * Name: Utakarsh Jain
 * Date: 13/11/2026
 */

package com.addressbook.dto;

public class AddressBookDTO {

    // Contact ID
    private int id;

    // Contact details
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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