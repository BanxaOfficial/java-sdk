package com.banxa.model;

import java.util.List;

public class Coin {
    private String coinCode;
    private String coinName;
    private List<Blockchain> blockchains;

    public String getCoinCode() {
        return coinCode;
    }

    public String getCoinName() {
        return coinName;
    }

    public List<Blockchain> getBlockchains() {
        return blockchains;
    }
}
