package com.helpdesk.crm.entities.manager;

import com.helpdesk.crm.dto.manager.ManagerRequest;
import com.helpdesk.crm.repositories.BaseEntity;
import com.helpdesk.crm.entities.schedule.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "managers")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Manager extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "managers_id_seq")
    @SequenceGenerator(name = "managers_id_seq", sequenceName = "managers_id_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String name;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Schedule> schedules = new HashSet<>();

    public Manager(ManagerRequest managerRequest) {
        this.id = managerRequest.getId();
        this.name = managerRequest.getName();
        this.phone = managerRequest.getPhone();
        this.email = managerRequest.getEmail();
    }
}
