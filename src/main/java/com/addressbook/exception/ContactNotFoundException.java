/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC3
 * Description: Handles cases where a requested contact does not exist.
 * Name: Utakarsh Jain
 * Date: 13/11/2026
 */

package com.addressbook.exception;

public class ContactNotFoundException extends RuntimeException {

    // Pass a meaningful message to the parent exception
    public ContactNotFoundException(String message) {
        super(message);
    }
}