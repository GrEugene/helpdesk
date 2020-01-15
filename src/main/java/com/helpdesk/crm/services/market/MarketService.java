package com.helpdesk.crm.services.market;

import com.helpdesk.crm.dto.market.MarketRequest;
import com.helpdesk.crm.dto.market.MarketResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MarketService {
    MarketResponse create(MarketRequest marketRequest);
    MarketResponse save(MarketRequest marketRequest);
    void delete(Long id);
    Page<MarketResponse> getAll(Pageable pageable);
    MarketResponse getById(Long id);
}
