package com.helpdesk.crm.services.schedule;

import com.helpdesk.crm.dto.schedule.ScheduleRequest;
import com.helpdesk.crm.dto.schedule.ScheduleResponse;
import com.helpdesk.crm.entities.schedule.Schedule;
import com.helpdesk.crm.exceptions.ScheduleNotFoundException;
import com.helpdesk.crm.repositories.schedule.ScheduleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponse create(ScheduleRequest scheduleRequest) {
        Schedule schedule = new Schedule(scheduleRequest);

        return new ScheduleResponse(scheduleRepository.save(schedule));
    }

    @Override
    public ScheduleResponse save(ScheduleRequest scheduleRequest) {
        Schedule schedule = new Schedule(scheduleRequest);

        return new ScheduleResponse(scheduleRepository.save(schedule));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Schedule schedule = scheduleRepository
                .findById(id)
                .orElseThrow(ScheduleNotFoundException::new);
        schedule.setIsActive(false);

        scheduleRepository.save(schedule);
    }

    @Override
    public Page<ScheduleResponse> getAll(Pageable pageable) {
        return scheduleRepository
                .findAll(pageable)
                .map(ScheduleResponse::new);
    }

    @Override
    public ScheduleResponse getById(Long id) {
        return scheduleRepository
                .findById(id)
                .map(ScheduleResponse::new)
                .orElseThrow(ScheduleNotFoundException::new);
    }
}
