package com.helpdesk.crm.exceptions;

public class ManagerNotFoundException extends NotFoundException {
    public ManagerNotFoundException() {
        super("MANAGER_NOT_FOUND");
    }
}
