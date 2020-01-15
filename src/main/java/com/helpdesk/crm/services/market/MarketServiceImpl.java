package com.helpdesk.crm.services.market;

import com.helpdesk.crm.dto.market.MarketRequest;
import com.helpdesk.crm.dto.market.MarketResponse;
import com.helpdesk.crm.entities.market.Market;
import com.helpdesk.crm.exceptions.MarketNotFoundException;
import com.helpdesk.crm.repositories.market.MarketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MarketServiceImpl implements MarketService {

    private final MarketRepository marketRepository;

    @Autowired
    public MarketServiceImpl(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @Override
    public MarketResponse create(MarketRequest marketRequest) {
        Market market = new Market(marketRequest);

        return new MarketResponse(marketRepository.save(market));
    }

    @Override
    public MarketResponse save(MarketRequest marketRequest) {
        Market market = new Market(marketRequest);

        return new MarketResponse(marketRepository.save(market));
    }

    @Override
    public void delete(Long id) {
        Market market = marketRepository
                .findById(id)
                .orElseThrow(MarketNotFoundException::new);
        market.setIsActive(false);

        marketRepository.save(market);
    }

    @Override
    public Page<MarketResponse> getAll(Pageable pageable) {
        return marketRepository
                .findAll(pageable)
                .map(MarketResponse::new);
    }

    @Override
    public MarketResponse getById(Long id) {
        return marketRepository.findById(id)
                .map(MarketResponse::new)
                .orElseThrow(MarketNotFoundException::new);
    }
}
