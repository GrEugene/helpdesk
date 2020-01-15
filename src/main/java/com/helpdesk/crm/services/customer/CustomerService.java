package com.helpdesk.crm.services.customer;

import com.helpdesk.crm.dto.customer.CustomerRequest;
import com.helpdesk.crm.dto.customer.CustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    CustomerResponse create(CustomerRequest customerRequest);
    CustomerResponse save(CustomerRequest customerRequest);
    void delete(Long id);
    Page<CustomerResponse> getAll(Pageable pageable);
    CustomerResponse getById(Long id);
}
