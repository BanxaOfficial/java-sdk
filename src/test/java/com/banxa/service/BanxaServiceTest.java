package com.banxa.service;

import com.banxa.client.BanxaClient;
import com.banxa.model.OrderType;
import com.banxa.model.TransactionFee;
import com.banxa.model.TransactionLimit;
import com.banxa.model.request.*;
import com.banxa.model.response.*;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.when;


public class BanxaServiceTest {

    @Test
    public void testGetFiatCurrenciesForBuy() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/fiats/buy", null))
                .thenReturn("{\"data\":{\"fiats\":[{\"fiat_code\": \"AUD\",\"fiat_name\":\"Australian Dollar\",\"fiat_symbol\":\"A$\"},{\"fiat_code\": \"USD\",\"fiat_name\":\"US Dollar\",\"fiat_symbol\":\"$\"}]}}");

        BanxaService service = new BanxaServiceImpl(client);
        BanxaResponse<GetFiatCurrenciesResponse> response = service.getFiatCurrencies(new GetFiatCurrenciesRequest(OrderType.BUY));

        assertThat(response.isSuccess(), is(Boolean.TRUE));
        assertThat(response.getResponse().getFiats().size(), is(2));
        assertThat(response.getResponse().getFiats().get(0).getFiatCode(), is("AUD"));
        assertThat(response.getResponse().getFiats().get(0).getFiatName(), is("Australian Dollar"));
        assertThat(response.getResponse().getFiats().get(0).getFiatSymbol(), is("A$"));

        assertThat(response.getResponse().getFiats().get(1).getFiatCode(), is("USD"));
        assertThat(response.getResponse().getFiats().get(1).getFiatName(), is("US Dollar"));
        assertThat(response.getResponse().getFiats().get(1).getFiatSymbol(), is("$"));
    }

    @Test
    public void testGetFiatCurrenciesForSell() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/fiats/sell", null))
                .thenReturn("{\"data\":{\"fiats\":[{\"fiat_code\": \"AUD\",\"fiat_name\":\"Australian Dollar\",\"fiat_symbol\":\"A$\"},{\"fiat_code\": \"USD\",\"fiat_name\":\"US Dollar\",\"fiat_symbol\":\"$\"}]}}");

        BanxaService service = new BanxaServiceImpl(client);
        BanxaResponse<GetFiatCurrenciesResponse> response = service.getFiatCurrencies(new GetFiatCurrenciesRequest(OrderType.SELL));

        assertThat(response.isSuccess(), is(Boolean.TRUE));
        assertThat(response.getResponse().getFiats().size(), is(2));
        assertThat(response.getResponse().getFiats().get(0).getFiatCode(), is("AUD"));
        assertThat(response.getResponse().getFiats().get(0).getFiatName(), is("Australian Dollar"));
        assertThat(response.getResponse().getFiats().get(0).getFiatSymbol(), is("A$"));

        assertThat(response.getResponse().getFiats().get(1).getFiatCode(), is("USD"));
        assertThat(response.getResponse().getFiats().get(1).getFiatName(), is("US Dollar"));
        assertThat(response.getResponse().getFiats().get(1).getFiatSymbol(), is("$"));
    }

    @Test
    public void testGetCryptoCurrenciesForBuy() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/coins/buy", null))
                .thenReturn("{\"data\":{\"coins\":[{\"coin_code\":\"BTC\",\"coin_name\":\"Bitcoin\",\"blockchains\":[{\"code\":\"BTC\",\"description\":\"Bitcoin\",\"is_default\":true}]},{\"coin_code\":\"ETH\",\"coin_name\":\"Ethereum\",\"blockchains\":[{\"code\":\"ETH\",\"description\":\"Ethereum (ERC20)\",\"is_default\":true},{\"code\":\"MATIC\",\"description\":\"Polygon\",\"is_default\":false}]}]}}");

        BanxaService service = new BanxaServiceImpl(client);
        BanxaResponse<GetCryptoCurrenciesResponse> response = service.getCryptoCurrencies(new GetCryptoCurrenciesRequest(OrderType.BUY));

        assertThat(response.isSuccess(), is(Boolean.TRUE));
        assertThat(response.getResponse().getCoins().size(), is(2));
        assertThat(response.getResponse().getCoins().get(0).getCoinCode(), is("BTC"));
        assertThat(response.getResponse().getCoins().get(0).getCoinName(), is("Bitcoin"));
        assertThat(response.getResponse().getCoins().get(0).getBlockchains().size(), is(1));
        assertThat(response.getResponse().getCoins().get(0).getBlockchains().get(0).getCode(), is("BTC"));
        assertThat(response.getResponse().getCoins().get(0).getBlockchains().get(0).getDescription(), is("Bitcoin"));
        assertThat(response.getResponse().getCoins().get(0).getBlockchains().get(0).getIsDefault(), is(Boolean.TRUE));

        assertThat(response.getResponse().getCoins().get(1).getCoinCode(), is("ETH"));
        assertThat(response.getResponse().getCoins().get(1).getCoinName(), is("Ethereum"));
        assertThat(response.getResponse().getCoins().get(1).getBlockchains().size(), is(2));
        assertThat(response.getResponse().getCoins().get(1).getBlockchains().get(0).getCode(), is("ETH"));
        assertThat(response.getResponse().getCoins().get(1).getBlockchains().get(0).getDescription(), is("Ethereum (ERC20)"));
        assertThat(response.getResponse().getCoins().get(1).getBlockchains().get(0).getIsDefault(), is(Boolean.TRUE));

        assertThat(response.getResponse().getCoins().get(1).getBlockchains().get(1).getCode(), is("MATIC"));
        assertThat(response.getResponse().getCoins().get(1).getBlockchains().get(1).getDescription(), is("Polygon"));
        assertThat(response.getResponse().getCoins().get(1).getBlockchains().get(1).getIsDefault(), is(Boolean.FALSE));
    }

    @Test
    public void testGetCryptoCurrenciesForSell() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/coins/sell", null))
                .thenReturn("{\"data\":{\"coins\":[{\"coin_code\":\"BTC\",\"coin_name\":\"Bitcoin\",\"blockchains\":[{\"code\":\"BTC\",\"description\":\"Bitcoin\",\"is_default\":true}]},{\"coin_code\":\"ETH\",\"coin_name\":\"Ethereum\",\"blockchains\":[{\"code\":\"ETH\",\"description\":\"Ethereum (ERC20)\",\"is_default\":true},{\"code\":\"MATIC\",\"description\":\"Polygon\",\"is_default\":false}]}]}}");

        BanxaService service = new BanxaServiceImpl(client);
        BanxaResponse<GetCryptoCurrenciesResponse> response = service.getCryptoCurrencies(new GetCryptoCurrenciesRequest(OrderType.SELL));

        assertThat(response.isSuccess(), is(Boolean.TRUE));
        assertThat(response.getResponse().getCoins().size(), is(2));
        assertThat(response.getResponse().getCoins().get(0).getCoinCode(), is("BTC"));
        assertThat(response.getResponse().getCoins().get(0).getCoinName(), is("Bitcoin"));
        assertThat(response.getResponse().getCoins().get(0).getBlockchains().size(), is(1));
        assertThat(response.getResponse().getCoins().get(0).getBlockchains().get(0).getCode(), is("BTC"));
        assertThat(response.getResponse().getCoins().get(0).getBlockchains().get(0).getDescription(), is("Bitcoin"));
        assertThat(response.getResponse().getCoins().get(0).getBlockchains().get(0).getIsDefault(), is(Boolean.TRUE));

        assertThat(response.getResponse().getCoins().get(1).getCoinCode(), is("ETH"));
        assertThat(response.getResponse().getCoins().get(1).getCoinName(), is("Ethereum"));
        assertThat(response.getResponse().getCoins().get(1).getBlockchains().size(), is(2));
        assertThat(response.getResponse().getCoins().get(1).getBlockchains().get(0).getCode(), is("ETH"));
        assertThat(response.getResponse().getCoins().get(1).getBlockchains().get(0).getDescription(), is("Ethereum (ERC20)"));
        assertThat(response.getResponse().getCoins().get(1).getBlockchains().get(0).getIsDefault(), is(Boolean.TRUE));

        assertThat(response.getResponse().getCoins().get(1).getBlockchains().get(1).getCode(), is("MATIC"));
        assertThat(response.getResponse().getCoins().get(1).getBlockchains().get(1).getDescription(), is("Polygon"));
        assertThat(response.getResponse().getCoins().get(1).getBlockchains().get(1).getIsDefault(), is(Boolean.FALSE));
    }

    @Test
    public void testGetCountries() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/countries", null))
                .thenReturn("{\"data\":{\"countries\":[{\"country_code\":\"AU\",\"country_name\":\"Australia\"},{\"country_code\":\"US\",\"country_name\":\"United States\"}]}}");

        BanxaService service = new BanxaServiceImpl(client);
        BanxaResponse<GetCountriesResponse> response = service.getCountries(new GetCountriesRequest());

        assertThat(response.isSuccess(), is(Boolean.TRUE));
        assertThat(response.getResponse().getCountries().size(), is(2));
        assertThat(response.getResponse().getCountries().get(0).getCountryCode(), is("AU"));
        assertThat(response.getResponse().getCountries().get(0).getCountryName(), is("Australia"));
        assertThat(response.getResponse().getCountries().get(1).getCountryCode(), is("US"));
        assertThat(response.getResponse().getCountries().get(1).getCountryName(), is("United States"));
    }

    @Test
    public void testGetUsStates() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/countries/us/states", null))
                .thenReturn("{\"data\":{\"states\":[{\"state_code\":\"AL\",\"state_name\":\"Alabama\"},{\"state_code\":\"AK\",\"state_name\":\"Alaska\"}]}}");

        BanxaService service = new BanxaServiceImpl(client);
        BanxaResponse<GetUsStatesResponse> response = service.getUsStates(new GetUsStatesRequest());

        assertThat(response.isSuccess(), is(Boolean.TRUE));
        assertThat(response.getResponse().getStates().size(), is(2));
        assertThat(response.getResponse().getStates().get(0).getStateCode(), is("AL"));
        assertThat(response.getResponse().getStates().get(0).getStateName(), is("Alabama"));
        assertThat(response.getResponse().getStates().get(1).getStateCode(), is("AK"));
        assertThat(response.getResponse().getStates().get(1).getStateName(), is("Alaska"));
    }

    @Test
    public void testPaymentMethods() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/payment-methods?source=AUD", null))
                .thenReturn("{\"data\":{\"payment_methods\":[" +
                        "{\"id\":5021,\"paymentType\":\"POLI\",\"name\":\"POLi\",\"description\":\"POLi Payments allow you to buy digital currency by bank transfer using your internet banking\",\"logo_url\":\"https:\\/\\/jeffjeff.banxa.com\\/images\\/payment-providers\\/poli.png\",\"status\":\"ACTIVE\",\"supported_agents\":null,\"type\":\"FIAT_TO_CRYPTO\",\"supported_fiat\":[\"AUD\"],\"supported_coin\":[\"BTC\",\"ETH\",\"USDT\"],\"transaction_fees\":[{\"fiat_code\":\"AUD\",\"coin_code\":\"BTC\",\"fees\":[]},{\"fiat_code\":\"AUD\",\"coin_code\":\"ETH\",\"fees\":[]}],\"transaction_limits\":[{\"fiat_code\":\"AUD\",\"min\":\"2\",\"max\":\"50000\"}]}," +
                        "{\"id\":5035,\"paymentType\":\"NPP\",\"name\":\"PayID\",\"description\":\"PayID is a payment method which allows you to make a near\\u2011instant deposit from your Australian bank account to buy digital currency\",\"logo_url\":\"https:\\/\\/jeffjeff.banxa.com\\/images\\/payment-providers\\/npp.png\",\"status\":\"ACTIVE\",\"supported_agents\":null,\"type\":\"FIAT_TO_CRYPTO\",\"supported_fiat\":[\"AUD\"],\"supported_coin\":[\"BTC\",\"ETH\",\"USDT\"],\"transaction_fees\":[{\"fiat_code\":\"AUD\",\"coin_code\":\"BTC\",\"fees\":[]},{\"fiat_code\":\"AUD\",\"coin_code\":\"ETH\",\"fees\":[]}],\"transaction_limits\":[{\"fiat_code\":\"AUD\",\"min\":\"2\",\"max\":\"50000\"}]}" +
                        "]}}");

        BanxaService service = new BanxaServiceImpl(client);
        BanxaResponse<GetPaymentMethodsResponse> response = service.getPaymentMethods(new GetPaymentMethodsRequest.Builder().withSource("AUD").build());

        assertThat(response.isSuccess(), is(Boolean.TRUE));
        assertThat(response.getResponse().getPaymentMethods().size(), is(2));
        assertThat(response.getResponse().getPaymentMethods().get(0).getId(), is(5021));
        assertThat(response.getResponse().getPaymentMethods().get(0).getName(), is("POLi"));
        assertThat(response.getResponse().getPaymentMethods().get(0).getDescription(), is("POLi Payments allow you to buy digital currency by bank transfer using your internet banking"));
        assertThat(response.getResponse().getPaymentMethods().get(0).getLogoUrl(), is("https://jeffjeff.banxa.com/images/payment-providers/poli.png"));
        assertThat(response.getResponse().getPaymentMethods().get(0).getStatus(), is("ACTIVE"));
        assertThat(response.getResponse().getPaymentMethods().get(0).getType(), is("FIAT_TO_CRYPTO"));
        assertThat(response.getResponse().getPaymentMethods().get(0).getSupportedAgents(), is(nullValue()));
        assertThat(response.getResponse().getPaymentMethods().get(0).getSupportedFiat(), is(List.of("AUD")));
        assertThat(response.getResponse().getPaymentMethods().get(0).getSupportedCoin(), is(List.of("BTC", "ETH", "USDT")));
        assertThat(response.getResponse().getPaymentMethods().get(0).getTransactionFees(), is(List.of(
                new TransactionFee("AUD", "BTC", Collections.emptyList()),
                new TransactionFee("AUD", "ETH", Collections.emptyList()))));
        assertThat(response.getResponse().getPaymentMethods().get(0).getTransactionLimits(), is(List.of(
                new TransactionLimit("AUD", 2.0, 50000.0)
        )));
    }

    @Test
    public void testPrices() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/prices?payment_method_id=5021&source=AUD&source_amount=100.0&target=BTC", null))
                .thenReturn("{\"data\":{\"spot_price\":\"32681.87\",\"prices\":[{\"payment_method_id\":5021,\"type\":\"FIAT_TO_CRYPTO\",\"spot_price_fee\":\"0.00\",\"spot_price_including_fee\":\"32681.87\",\"coin_amount\":\"0.00305980\",\"coin_code\":\"BTC\",\"fiat_amount\":\"100.00\",\"fiat_code\":\"AUD\",\"fee_amount\":\"0.00\",\"network_fee\":\"0.19\"}]}}");

        BanxaService service = new BanxaServiceImpl(client);
        BanxaResponse<GetPricesResponse> response = service.getPrices(new GetPricesRequest.Builder("AUD", "BTC").withPaymentMethodId(5021).withSourceAmount(100.0).build());

        assertThat(response.isSuccess(), is(Boolean.TRUE));
        assertThat(response.getResponse().getSpotPrice(), is("32681.87"));
        assertThat(response.getResponse().getPrices().size(), is(1));
        assertThat(response.getResponse().getPrices().get(0).getPaymentMethodId(), is(5021));
        assertThat(response.getResponse().getPrices().get(0).getType(), is("FIAT_TO_CRYPTO"));
        assertThat(response.getResponse().getPrices().get(0).getSpotPriceFee(), is("0.00"));
        assertThat(response.getResponse().getPrices().get(0).getSpotPriceIncludingFee(), is("32681.87"));
        assertThat(response.getResponse().getPrices().get(0).getCoinAmount(), is("0.00305980"));
        assertThat(response.getResponse().getPrices().get(0).getCoinCode(), is("BTC"));
        assertThat(response.getResponse().getPrices().get(0).getFiatAmount(), is("100.00"));
        assertThat(response.getResponse().getPrices().get(0).getFiatCode(), is("AUD"));
        assertThat(response.getResponse().getPrices().get(0).getFeeAmount(), is("0.00"));
        assertThat(response.getResponse().getPrices().get(0).getNetworkFee(), is("0.19"));
    }

    public void testTemplate() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/payment-methods", null))
                .thenReturn("");

        BanxaService service = new BanxaServiceImpl(client);
        BanxaResponse<GetFiatCurrenciesResponse> response = service.getFiatCurrencies(new GetFiatCurrenciesRequest(OrderType.BUY));

        assertThat(response.isSuccess(), is(Boolean.TRUE));
        assertThat(response.getResponse().getFiats().size(), is(2));
        assertThat(response.getResponse().getFiats().get(0).getFiatCode(), is("AUD"));
    }

}
