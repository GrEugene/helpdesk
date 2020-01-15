package com.helpdesk.crm.exceptions;

public class CustomerNotFoundException extends NotFoundException {
    public CustomerNotFoundException() {
        super("CUSTOMER_NOT_FOUND");
    }
}
