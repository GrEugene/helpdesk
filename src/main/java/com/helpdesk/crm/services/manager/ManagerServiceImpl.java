package com.helpdesk.crm.services.manager;

import com.helpdesk.crm.dto.manager.ManagerRequest;
import com.helpdesk.crm.dto.manager.ManagerResponse;
import com.helpdesk.crm.entities.manager.Manager;
import com.helpdesk.crm.exceptions.ManagerNotFoundException;
import com.helpdesk.crm.repositories.manager.ManagerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }


    @Override
    public ManagerResponse create(ManagerRequest managerRequest) {
        Manager manager = new Manager(managerRequest);

        return new ManagerResponse(managerRepository.save(manager));
    }

    @Override
    public ManagerResponse save(ManagerRequest managerRequest) {
        Manager manager = new Manager(managerRequest);

        return new ManagerResponse(managerRepository.save(manager));
    }

    @Override
    public void delete(Long id) {
        Manager manager = managerRepository
                .findById(id)
                .orElseThrow(ManagerNotFoundException::new);
        manager.setIsActive(false);

        managerRepository.save(manager);
    }

    @Override
    public Page<ManagerResponse> getAll(Pageable pageable) {
        return managerRepository
                .findAll(pageable)
                .map(ManagerResponse::new);
    }

    @Override
    public ManagerResponse getById(Long id) {
        return managerRepository.findById(id)
                .map(ManagerResponse::new)
                .orElseThrow(ManagerNotFoundException::new);
    }
}
