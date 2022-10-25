package com.banxa.model.response;

import com.banxa.model.Price;

import java.util.List;

public class GetPricesResponse {
    private String spotPrice;
    private List<Price> prices;

    public String getSpotPrice() {
        return spotPrice;
    }

    public List<Price> getPrices() {
        return prices;
    }
}
