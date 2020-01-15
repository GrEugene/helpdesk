package com.helpdesk.crm.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApplicationException {
    public NotFoundException(String code) {super(HttpStatus.NOT_FOUND, code);}
}
