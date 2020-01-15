package com.helpdesk.crm.entities.market;

import com.helpdesk.crm.dto.market.MarketRequest;
import com.helpdesk.crm.entities.customer.Customer;
import com.helpdesk.crm.repositories.BaseEntity;
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

    public Market(MarketRequest marketRequest) {
        this.id = marketRequest.getId();
        this.name = marketRequest.getName();
        this.phone = marketRequest.getPhone();
        this.address = marketRequest.getAddress();
        this.contactName = marketRequest.getContactName();
        this.contactPhone = marketRequest.getContactPhone();
        this.contactEmail = marketRequest.getContactEmail();
    }
}
