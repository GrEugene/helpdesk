package com.helpdesk.crm.entities.schedule;

import com.helpdesk.crm.dto.schedule.ScheduleRequest;
import com.helpdesk.crm.entities.manager.Manager;
import com.helpdesk.crm.entities.worker.Worker;
import com.helpdesk.crm.repositories.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "schedule")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_id_seq")
    @SequenceGenerator(name = "schedule_id_seq", sequenceName = "schedule_id_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String name;
    private Date dateFrom;
    private Date dateTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Worker worker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Manager manager;

    public Schedule(ScheduleRequest scheduleRequest) {
        this.id = scheduleRequest.getId();
        this.name = scheduleRequest.getName();
        this.dateFrom = scheduleRequest.getDateFrom();
        this.dateTo = scheduleRequest.getDateTo();
    }
}
