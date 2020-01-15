package com.helpdesk.crm.exceptions;

public class OrderNotFoundException extends NotFoundException {
    public OrderNotFoundException() {
        super("ORDER_NOT_FOUND");
    }
}
