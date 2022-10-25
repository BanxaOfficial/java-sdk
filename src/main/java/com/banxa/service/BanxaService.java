package com.banxa.service;

import com.banxa.model.request.*;
import com.banxa.model.response.*;

public interface BanxaService {
    BanxaResponse<GetFiatCurrenciesResponse> getFiatCurrencies(GetFiatCurrenciesRequest request);
    BanxaResponse<GetCryptoCurrenciesResponse> getCryptoCurrencies(GetCryptoCurrenciesRequest request);
    BanxaResponse<GetCountriesResponse> getCountries(GetCountriesRequest request);
    BanxaResponse<GetUsStatesResponse> getUsStates(GetUsStatesRequest request);
    BanxaResponse<GetPaymentMethodsResponse> getPaymentMethods(GetPaymentMethodsRequest request);
    BanxaResponse<GetPricesResponse> getPrices(GetPricesRequest request);
    BanxaResponse<GetOrderResponse> getOrder(GetOrderRequest request);
    BanxaResponse<GetOrdersResponse> getOrders(GetOrdersRequest request);
    BanxaResponse<CreateBuyOrderResponse> createBuyOrder(CreateBuyOrderRequest request);
    BanxaResponse<CreateSellOrderResponse> createSellOrder(CreateSellOrderRequest request);
    BanxaResponse<CreateNftOrderResponse> createNftOrder(CreateNftOrderRequest request);
    BanxaResponse<ConfirmSellOrderResponse> confirmSellOrder(ConfirmSellOrderRequest request);
    BanxaResponse<CreateIdentityResponse> createIdentity(CreateIdentityRequest request);
}
