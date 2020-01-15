package com.helpdesk.crm.controllers;

import com.helpdesk.crm.dto.order.OrderRequest;
import com.helpdesk.crm.dto.order.OrderResponse;
import com.helpdesk.crm.dto.worker.WorkerRequest;
import com.helpdesk.crm.dto.worker.WorkerResponse;
import com.helpdesk.crm.services.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/orders", produces = APPLICATION_JSON_VALUE)
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse create(@RequestBody OrderRequest orderRequest) {
        return orderService.create(orderRequest);
    }

    @PutMapping
    public OrderResponse save(@RequestBody OrderRequest orderRequest) {
        return orderService.save(orderRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        orderService.delete(id);
    }

    @GetMapping("/{id}")
    public OrderResponse getById(@PathVariable("id") Long id) {
        return orderService.getById(id);
    }

    @GetMapping
    public Page<OrderResponse> getAll(@PageableDefault(size = 20) Pageable pageable) {
        return orderService.getAll(pageable);
    }
}
