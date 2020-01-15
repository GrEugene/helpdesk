package com.helpdesk.crm.services.worker;

import com.helpdesk.crm.dto.worker.WorkerRequest;
import com.helpdesk.crm.dto.worker.WorkerResponse;
import com.helpdesk.crm.entities.worker.Worker;
import com.helpdesk.crm.exceptions.WorkerNotFoundException;
import com.helpdesk.crm.repositories.worker.WorkerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public WorkerResponse create(WorkerRequest workerRequest) {
        Worker worker = new Worker(workerRequest);

        return new WorkerResponse(workerRepository.save(worker));
    }

    @Override
    public WorkerResponse save(WorkerRequest workerRequest) {
        Worker worker = new Worker(workerRequest);

        return new WorkerResponse(workerRepository.save(worker));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Worker worker = workerRepository
                .findById(id)
                .orElseThrow(WorkerNotFoundException::new);
        worker.setIsActive(false);

        workerRepository.save(worker);
    }

    @Override
    public Page<WorkerResponse> getAll(Pageable pageable) {
        return workerRepository
                .findAll(pageable)
                .map(WorkerResponse::new);
    }

    @Override
    public WorkerResponse getById(Long id) {
        return workerRepository.findById(id)
                .map(WorkerResponse::new)
                .orElseThrow(WorkerNotFoundException::new);
    }
}
