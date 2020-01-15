package com.helpdesk.crm.repositories.market;

import com.helpdesk.crm.entities.market.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
}
