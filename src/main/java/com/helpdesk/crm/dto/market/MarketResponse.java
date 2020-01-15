package com.helpdesk.crm.dto.market;

import com.helpdesk.crm.entities.market.Market;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketResponse {
    private Long id;
    private String name;
    private String phone;
    private String address;
    private String contactName;
    private String contactPhone;
    private String contactEmail;

    public MarketResponse(Market market) {
        this.id = market.getId();
        this.name = market.getName();
        this.phone = market.getPhone();
        this.address = market.getAddress();
        this.contactPhone = market.getContactPhone();
        this.contactEmail = market.getContactEmail();
        this.contactName = market.getContactName();
    }
}
