package com.helpdesk.crm.dto.manager;


import com.helpdesk.crm.entities.manager.Manager;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManagerResponse {
    private Long id;
    private String name;
    private String phone;
    private String email;

    public ManagerResponse(Manager manager) {
        this.id = manager.getId();
        this.name = manager.getName();
        this.phone = manager.getPhone();
        this.email = manager.getEmail();
    }
}
