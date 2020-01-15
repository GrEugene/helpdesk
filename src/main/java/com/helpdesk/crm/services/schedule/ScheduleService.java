package com.helpdesk.crm.services.schedule;

import com.helpdesk.crm.dto.schedule.ScheduleRequest;
import com.helpdesk.crm.dto.schedule.ScheduleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScheduleService {
    ScheduleResponse create(ScheduleRequest scheduleRequest);
    ScheduleResponse save(ScheduleRequest scheduleRequest);
    void delete(Long id);
    Page<ScheduleResponse> getAll(Pageable pageable);
    ScheduleResponse getById(Long id);
}
