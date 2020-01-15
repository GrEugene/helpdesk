package com.helpdesk.crm.services.customer;

import com.helpdesk.crm.dto.customer.CustomerRequest;
import com.helpdesk.crm.dto.customer.CustomerResponse;
import com.helpdesk.crm.entities.customer.Customer;
import com.helpdesk.crm.exceptions.CustomerNotFoundException;
import com.helpdesk.crm.repositories.customer.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse create(CustomerRequest customerRequest) {
        Customer customer = new Customer(customerRequest);

        return new CustomerResponse(customerRepository.save(customer));
    }

    @Override
    public CustomerResponse save(CustomerRequest customerRequest) {
        Customer customer = new Customer(customerRequest);

        return new CustomerResponse(customerRepository.save(customer));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Customer customer = customerRepository
                .findById(id)
                .orElseThrow(CustomerNotFoundException::new);
        customer.setIsActive(false);

        customerRepository.save(customer);
    }

    @Override
    public Page<CustomerResponse> getAll(Pageable pageable) {
        return customerRepository
                .findAll(pageable)
                .map(CustomerResponse::new);
    }

    @Override
    public CustomerResponse getById(Long id) {
        return customerRepository.findById(id)
                .map(CustomerResponse::new)
                .orElseThrow(CustomerNotFoundException::new);
    }
}
