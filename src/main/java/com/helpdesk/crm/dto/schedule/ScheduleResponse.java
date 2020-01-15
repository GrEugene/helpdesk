package com.helpdesk.crm.dto.schedule;

import com.helpdesk.crm.entities.schedule.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponse {
    private Long id;
    private String name;
    private Date dateFrom;
    private Date dateTo;

    public ScheduleResponse(Schedule schedule) {
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.dateFrom = schedule.getDateFrom();
        this.dateTo = schedule.getDateTo();
    }
}
