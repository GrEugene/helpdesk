package com.helpdesk.crm.controllers;

import com.helpdesk.crm.dto.worker.WorkerRequest;
import com.helpdesk.crm.dto.worker.WorkerResponse;
import com.helpdesk.crm.services.worker.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workers")
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
    public Page<WorkerResponse> getAll() {
        return workerService.getAll();
    }
}
