package com.helpdesk.crm.exceptions;

public class MarketNotFoundException extends NotFoundException {
    public MarketNotFoundException() {
        super("MARKET_NOT_FOUND");
    }
}
