package com.helpdesk.crm.controllers;

import com.helpdesk.crm.dto.manager.ManagerRequest;
import com.helpdesk.crm.dto.manager.ManagerResponse;
import com.helpdesk.crm.services.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ManagerResponse create(@RequestBody ManagerRequest managerRequest) {
        return managerService.create(managerRequest);
    }

    @PutMapping
    public ManagerResponse save(@RequestBody ManagerRequest managerRequest) {
        return managerService.save(managerRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        managerService.delete(id);
    }

    @GetMapping("/{id}")
    public ManagerResponse getById(@PathVariable("id") Long id) {
        return managerService.getById(id);
    }

    @GetMapping
    public Page<ManagerResponse> getAll(@PageableDefault(size = 20) Pageable pageable) {
        return managerService.getAll(pageable);
    }
}
