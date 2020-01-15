package com.helpdesk.crm.exceptions;

public class WorkerNotFoundException extends NotFoundException {
    public WorkerNotFoundException() {
        super("WORKER_NOT_FOUND");
    }
}
