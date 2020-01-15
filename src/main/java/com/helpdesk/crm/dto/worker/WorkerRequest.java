package com.helpdesk.crm.dto.worker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerRequest implements Serializable {
    private Long id;
    private String name;
    private String phone;
    private String email;
}
