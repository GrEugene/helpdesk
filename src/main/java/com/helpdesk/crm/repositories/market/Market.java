package com.helpdesk.crm.repositories.market;

import com.helpdesk.crm.repositories.BaseEntity;
import com.helpdesk.crm.repositories.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "markets")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Market extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "markets_id_seq")
    @SequenceGenerator(name = "markets_id_seq", sequenceName = "markets_id_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String name;
    private String phone;
    private String address;
    private String contactName;
    private String contactPhone;
    private String contactEmail;

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Customer> customers = new HashSet<>();
}
