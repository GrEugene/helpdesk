package com.helpdesk.crm.repositories.order;

import com.helpdesk.crm.repositories.BaseEntity;
import com.helpdesk.crm.repositories.customer.Customer;
import com.helpdesk.crm.repositories.market.Market;
import com.helpdesk.crm.repositories.worker.Worker;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_id_seq")
    @SequenceGenerator(name = "orders_id_seq", sequenceName = "orders_id_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String name;
    private String description;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Worker worker;
}
