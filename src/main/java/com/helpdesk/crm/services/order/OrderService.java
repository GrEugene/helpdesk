package com.helpdesk.crm.services.order;

import com.helpdesk.crm.dto.order.OrderRequest;
import com.helpdesk.crm.dto.order.OrderResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    OrderResponse create(OrderRequest orderRequest);
    OrderResponse save(OrderRequest orderRequest);
    void delete(Long id);
    Page<OrderResponse> getAll(Pageable pageable);
    OrderResponse getById(Long id);
}
