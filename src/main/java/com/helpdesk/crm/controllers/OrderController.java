package com.helpdesk.crm.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/orders", produces = APPLICATION_JSON_VALUE)
@Slf4j
public class OrderController {
}
