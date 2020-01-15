package com.helpdesk.crm.exceptions;

public class ScheduleNotFoundException extends NotFoundException {
    public ScheduleNotFoundException() {
        super("SCHEDULE_NOT_FOUND");
    }
}
