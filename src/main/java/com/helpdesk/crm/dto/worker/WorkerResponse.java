package com.helpdesk.crm.dto.worker;

import com.helpdesk.crm.entities.worker.Worker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkerResponse implements Serializable {
    private Long id;
    private String name;
    private String phone;
    private String email;

    public WorkerResponse(Worker worker) {
        this.id = worker.getId();
        this.name = worker.getName();
        this.phone = worker.getPhone();
        this.email = worker.getEmail();
    }
}
