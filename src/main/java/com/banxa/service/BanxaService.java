package com.banxa.service;

import com.banxa.exception.BanxaException;
import com.banxa.model.request.*;
import com.banxa.model.response.*;

public interface BanxaService {
    GetFiatCurrenciesResponse getFiatCurrencies(GetFiatCurrenciesRequest request) throws BanxaException;
    GetCryptoCurrenciesResponse getCryptoCurrencies(GetCryptoCurrenciesRequest request) throws BanxaException;
    GetCountriesResponse getCountries(GetCountriesRequest request) throws BanxaException;
    GetUsStatesResponse getUsStates(GetUsStatesRequest request) throws BanxaException;
    GetPaymentMethodsResponse getPaymentMethods(GetPaymentMethodsRequest request) throws BanxaException;
    GetPricesResponse getPrices(GetPricesRequest request) throws BanxaException;
    GetOrderResponse getOrder(GetOrderRequest request) throws BanxaException;
    GetOrdersResponse getOrders(GetOrdersRequest request) throws BanxaException;
    CreateBuyOrderResponse createBuyOrder(CreateBuyOrderRequest request) throws BanxaException;
    CreateSellOrderResponse createSellOrder(CreateSellOrderRequest request) throws BanxaException;
    CreateNftOrderResponse createNftOrder(CreateNftOrderRequest request) throws BanxaException;
    ConfirmSellOrderResponse confirmSellOrder(ConfirmSellOrderRequest request) throws BanxaException;
    CreateIdentityResponse createIdentity(CreateIdentityRequest request) throws BanxaException;
}
