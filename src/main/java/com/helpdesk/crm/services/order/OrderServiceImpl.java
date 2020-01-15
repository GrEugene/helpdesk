package com.helpdesk.crm.services.order;

import com.helpdesk.crm.dto.order.OrderRequest;
import com.helpdesk.crm.dto.order.OrderResponse;
import com.helpdesk.crm.dto.worker.WorkerResponse;
import com.helpdesk.crm.entities.order.Order;
import com.helpdesk.crm.entities.worker.Worker;
import com.helpdesk.crm.exceptions.OrderNotFoundException;
import com.helpdesk.crm.exceptions.WorkerNotFoundException;
import com.helpdesk.crm.repositories.order.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderResponse create(OrderRequest orderRequest) {
        Order order = new Order(orderRequest);

        return new OrderResponse(orderRepository.save(order));
    }

    @Override
    public OrderResponse save(OrderRequest orderRequest) {
        Order order = new Order(orderRequest);

        return new OrderResponse(orderRepository.save(order));
    }

    @Override
    public void delete(Long id) {
        Order order = orderRepository
                .findById(id)
                .orElseThrow(OrderNotFoundException::new);
        order.setIsActive(false);

        orderRepository.save(order);
    }

    @Override
    public Page<OrderResponse> getAll(Pageable pageable) {
        return orderRepository
                .findAll(pageable)
                .map(OrderResponse::new);
    }

    @Override
    public OrderResponse getById(Long id) {
        return orderRepository.findById(id)
                .map(OrderResponse::new)
                .orElseThrow(OrderNotFoundException::new);
    }
}
