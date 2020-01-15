package com.helpdesk.crm.controllers;

import com.helpdesk.crm.dto.manager.ManagerRequest;
import com.helpdesk.crm.dto.manager.ManagerResponse;
import com.helpdesk.crm.dto.market.MarketRequest;
import com.helpdesk.crm.dto.market.MarketResponse;
import com.helpdesk.crm.services.market.MarketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/markets", produces = APPLICATION_JSON_VALUE)
@Slf4j
public class MarketController {
    private final MarketService marketService;

    @Autowired
    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MarketResponse create(@RequestBody MarketRequest marketRequest) {
        return marketService.create(marketRequest);
    }

    @PutMapping
    public MarketResponse save(@RequestBody MarketRequest marketRequest) {
        return marketService.save(marketRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        marketService.delete(id);
    }

    @GetMapping("/{id}")
    public MarketResponse getById(@PathVariable("id") Long id) {
        return marketService.getById(id);
    }

    @GetMapping
    public Page<MarketResponse> getAll(@PageableDefault(size = 20) Pageable pageable) {
        return marketService.getAll(pageable);
    }
}
