package com.helpdesk.crm.controllers;

import com.helpdesk.crm.dto.worker.WorkerRequest;
import com.helpdesk.crm.dto.worker.WorkerResponse;
import com.helpdesk.crm.services.worker.WorkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/workers", produces = APPLICATION_JSON_VALUE)
@Slf4j
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkerResponse create(@RequestBody WorkerRequest worker) {
        return workerService.create(worker);
    }

    @PutMapping
    public WorkerResponse save(@RequestBody WorkerRequest worker) {
        return workerService.save(worker);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        workerService.delete(id);
    }

    @GetMapping("/{id}")
    public WorkerResponse getById(@PathVariable("id") Long id) {
        return workerService.getById(id);
    }

    @GetMapping
    public Page<WorkerResponse> getAll(@PageableDefault(size = 20) Pageable pageable) {
        return workerService.getAll(pageable);
    }
}
