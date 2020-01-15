package com.helpdesk.crm.services.worker;

import com.helpdesk.crm.dto.worker.WorkerRequest;
import com.helpdesk.crm.dto.worker.WorkerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WorkerService {
    WorkerResponse create(WorkerRequest workerRequest);
    WorkerResponse save(WorkerRequest workerRequest);
    void delete(Long id);
    Page<WorkerResponse> getAll(Pageable pageable);
    WorkerResponse getById(Long id);
}
