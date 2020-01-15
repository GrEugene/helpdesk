package com.helpdesk.crm.dto.market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketRequest {
    private Long id;
    private String name;
    private String phone;
    private String address;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
}
