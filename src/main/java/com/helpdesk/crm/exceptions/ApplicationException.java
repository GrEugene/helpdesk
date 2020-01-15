package com.helpdesk.crm.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApplicationException extends RuntimeException {
    private final HttpStatus status;
    private final String code;
    private String message;
    private final Object details;

    public ApplicationException(String code) {
        this.status = HttpStatus.CONFLICT;
        this.code = code;
        this.message = null;
        this.details = null;
    }

    public ApplicationException(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
        this.message = null;
        this.details = null;
    }

    public ApplicationException(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.details = null;
    }

    public ApplicationException(HttpStatus status, String code, String message, Object details) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.details = details;
    }
}
