package com.helpdesk.crm.controllers;

import com.helpdesk.crm.dto.schedule.ScheduleRequest;
import com.helpdesk.crm.dto.schedule.ScheduleResponse;
import com.helpdesk.crm.services.schedule.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/schedulers", produces = APPLICATION_JSON_VALUE)
@Slf4j
public class ScheduleController {
    
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScheduleResponse create(@RequestBody ScheduleRequest scheduleRequest) {
        return scheduleService.create(scheduleRequest);
    }

    @PutMapping
    public ScheduleResponse save(@RequestBody ScheduleRequest scheduleRequest) {
        return scheduleService.save(scheduleRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        scheduleService.delete(id);
    }

    @GetMapping("/{id}")
    public ScheduleResponse getById(@PathVariable("id") Long id) {
        return scheduleService.getById(id);
    }

    @GetMapping
    public Page<ScheduleResponse> getAll(@PageableDefault(size = 20) Pageable pageable) {
        return scheduleService.getAll(pageable);
    }
}
