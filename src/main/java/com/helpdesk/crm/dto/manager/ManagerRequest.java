package com.helpdesk.crm.dto.manager;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManagerRequest {
    private Long id;
    private String name;
    private String phone;
    private String email;
}
