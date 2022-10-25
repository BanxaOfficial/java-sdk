package com.banxa.model.response;

import com.banxa.model.Coin;

import java.util.List;

public class GetCryptoCurrenciesResponse {
    private List<Coin> coins;

    public List<Coin> getCoins() {
        return coins;
    }
}
