package com.helpdesk.crm.controllers;

import com.helpdesk.crm.dto.customer.CustomerRequest;
import com.helpdesk.crm.dto.customer.CustomerResponse;
import com.helpdesk.crm.services.customer.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workers")
@Slf4j
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@RequestBody CustomerRequest customerRequest) {
        return customerService.create(customerRequest);
    }

    @PutMapping
    public CustomerResponse save(@RequestBody CustomerRequest customerRequest) {
        return customerService.save(customerRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        customerService.delete(id);
    }

    @GetMapping("/{id}")
    public CustomerResponse getById(@PathVariable("id") Long id) {
        return customerService.getById(id);
    }

    @GetMapping
    public Page<CustomerResponse> getAll(@PageableDefault(size = 20) Pageable pageable) {
        return customerService.getAll(pageable);
    }
}
