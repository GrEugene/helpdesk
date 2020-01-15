package com.helpdesk.crm.dto.order;

import com.helpdesk.crm.entities.order.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private String name;
    private String description;
    private String status;

    public OrderResponse(Order order) {
        this.id = order.getId();
        this.name = order.getName();
        this.description = order.getDescription();
        this.status = order.getStatus();
    }
}
