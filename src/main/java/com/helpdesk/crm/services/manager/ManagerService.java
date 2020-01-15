package com.helpdesk.crm.services.manager;

import com.helpdesk.crm.dto.manager.ManagerRequest;
import com.helpdesk.crm.dto.manager.ManagerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManagerService {
    ManagerResponse create(ManagerRequest managerRequest);
    ManagerResponse save(ManagerRequest managerRequest);
    void delete(Long id);
    Page<ManagerResponse> getAll(Pageable pageable);
    ManagerResponse getById(Long id);
}
