package com.banxa.model.response;

import com.banxa.model.Fiat;

import java.util.List;

public class GetFiatCurrenciesResponse {
    private List<Fiat> fiats;

    public List<Fiat> getFiats() {
        return fiats;
    }
}
