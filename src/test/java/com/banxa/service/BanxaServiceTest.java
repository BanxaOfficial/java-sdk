package com.banxa.service;

import com.banxa.client.BanxaClient;
import com.banxa.client.BanxaClientResponse;
import com.banxa.exception.BanxaException;
import com.banxa.model.IdentityDocumentType;
import com.banxa.model.OrderType;
import com.banxa.model.TransactionFee;
import com.banxa.model.TransactionLimit;
import com.banxa.model.request.*;
import com.banxa.model.response.*;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;


public class BanxaServiceTest {

    @Test
    public void testGetFiatCurrenciesForBuy() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/fiats/buy", null))
                .thenReturn(new BanxaClientResponse(200, "{\"data\":{\"fiats\":[{\"fiat_code\": \"AUD\",\"fiat_name\":\"Australian Dollar\",\"fiat_symbol\":\"A$\"},{\"fiat_code\": \"USD\",\"fiat_name\":\"US Dollar\",\"fiat_symbol\":\"$\"}]}}"));

        BanxaService service = new BanxaServiceImpl(client);
        GetFiatCurrenciesResponse response = service.getFiatCurrencies(new GetFiatCurrenciesRequest(OrderType.BUY));

        assertThat(response.getFiats().size(), is(2));
        assertThat(response.getFiats().get(0).getFiatCode(), is("AUD"));
        assertThat(response.getFiats().get(0).getFiatName(), is("Australian Dollar"));
        assertThat(response.getFiats().get(0).getFiatSymbol(), is("A$"));

        assertThat(response.getFiats().get(1).getFiatCode(), is("USD"));
        assertThat(response.getFiats().get(1).getFiatName(), is("US Dollar"));
        assertThat(response.getFiats().get(1).getFiatSymbol(), is("$"));
    }

    @Test
    public void testGetFiatCurrenciesForSell() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/fiats/sell", null))
                .thenReturn(new BanxaClientResponse(200, "{\"data\":{\"fiats\":[{\"fiat_code\": \"AUD\",\"fiat_name\":\"Australian Dollar\",\"fiat_symbol\":\"A$\"},{\"fiat_code\": \"USD\",\"fiat_name\":\"US Dollar\",\"fiat_symbol\":\"$\"}]}}"));

        BanxaService service = new BanxaServiceImpl(client);
        GetFiatCurrenciesResponse response = service.getFiatCurrencies(new GetFiatCurrenciesRequest(OrderType.SELL));

        assertThat(response.getFiats().size(), is(2));
        assertThat(response.getFiats().get(0).getFiatCode(), is("AUD"));
        assertThat(response.getFiats().get(0).getFiatName(), is("Australian Dollar"));
        assertThat(response.getFiats().get(0).getFiatSymbol(), is("A$"));

        assertThat(response.getFiats().get(1).getFiatCode(), is("USD"));
        assertThat(response.getFiats().get(1).getFiatName(), is("US Dollar"));
        assertThat(response.getFiats().get(1).getFiatSymbol(), is("$"));
    }

    @Test
    public void testGetCryptoCurrenciesForBuy() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/coins/buy", null))
                .thenReturn(new BanxaClientResponse(200, "{\"data\":{\"coins\":[{\"coin_code\":\"BTC\",\"coin_name\":\"Bitcoin\",\"blockchains\":[{\"code\":\"BTC\",\"description\":\"Bitcoin\",\"is_default\":true}]},{\"coin_code\":\"ETH\",\"coin_name\":\"Ethereum\",\"blockchains\":[{\"code\":\"ETH\",\"description\":\"Ethereum (ERC20)\",\"is_default\":true},{\"code\":\"MATIC\",\"description\":\"Polygon\",\"is_default\":false}]}]}}"));

        BanxaService service = new BanxaServiceImpl(client);
        GetCryptoCurrenciesResponse response = service.getCryptoCurrencies(new GetCryptoCurrenciesRequest(OrderType.BUY));

        assertThat(response.getCoins().size(), is(2));
        assertThat(response.getCoins().get(0).getCoinCode(), is("BTC"));
        assertThat(response.getCoins().get(0).getCoinName(), is("Bitcoin"));
        assertThat(response.getCoins().get(0).getBlockchains().size(), is(1));
        assertThat(response.getCoins().get(0).getBlockchains().get(0).getCode(), is("BTC"));
        assertThat(response.getCoins().get(0).getBlockchains().get(0).getDescription(), is("Bitcoin"));
        assertThat(response.getCoins().get(0).getBlockchains().get(0).getIsDefault(), is(Boolean.TRUE));

        assertThat(response.getCoins().get(1).getCoinCode(), is("ETH"));
        assertThat(response.getCoins().get(1).getCoinName(), is("Ethereum"));
        assertThat(response.getCoins().get(1).getBlockchains().size(), is(2));
        assertThat(response.getCoins().get(1).getBlockchains().get(0).getCode(), is("ETH"));
        assertThat(response.getCoins().get(1).getBlockchains().get(0).getDescription(), is("Ethereum (ERC20)"));
        assertThat(response.getCoins().get(1).getBlockchains().get(0).getIsDefault(), is(Boolean.TRUE));

        assertThat(response.getCoins().get(1).getBlockchains().get(1).getCode(), is("MATIC"));
        assertThat(response.getCoins().get(1).getBlockchains().get(1).getDescription(), is("Polygon"));
        assertThat(response.getCoins().get(1).getBlockchains().get(1).getIsDefault(), is(Boolean.FALSE));
    }

    @Test
    public void testGetCryptoCurrenciesForSell() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/coins/sell", null))
                .thenReturn(new BanxaClientResponse(200, "{\"data\":{\"coins\":[{\"coin_code\":\"BTC\",\"coin_name\":\"Bitcoin\",\"blockchains\":[{\"code\":\"BTC\",\"description\":\"Bitcoin\",\"is_default\":true}]},{\"coin_code\":\"ETH\",\"coin_name\":\"Ethereum\",\"blockchains\":[{\"code\":\"ETH\",\"description\":\"Ethereum (ERC20)\",\"is_default\":true},{\"code\":\"MATIC\",\"description\":\"Polygon\",\"is_default\":false}]}]}}"));

        BanxaService service = new BanxaServiceImpl(client);
        GetCryptoCurrenciesResponse response = service.getCryptoCurrencies(new GetCryptoCurrenciesRequest(OrderType.SELL));

        assertThat(response.getCoins().size(), is(2));
        assertThat(response.getCoins().get(0).getCoinCode(), is("BTC"));
        assertThat(response.getCoins().get(0).getCoinName(), is("Bitcoin"));
        assertThat(response.getCoins().get(0).getBlockchains().size(), is(1));
        assertThat(response.getCoins().get(0).getBlockchains().get(0).getCode(), is("BTC"));
        assertThat(response.getCoins().get(0).getBlockchains().get(0).getDescription(), is("Bitcoin"));
        assertThat(response.getCoins().get(0).getBlockchains().get(0).getIsDefault(), is(Boolean.TRUE));

        assertThat(response.getCoins().get(1).getCoinCode(), is("ETH"));
        assertThat(response.getCoins().get(1).getCoinName(), is("Ethereum"));
        assertThat(response.getCoins().get(1).getBlockchains().size(), is(2));
        assertThat(response.getCoins().get(1).getBlockchains().get(0).getCode(), is("ETH"));
        assertThat(response.getCoins().get(1).getBlockchains().get(0).getDescription(), is("Ethereum (ERC20)"));
        assertThat(response.getCoins().get(1).getBlockchains().get(0).getIsDefault(), is(Boolean.TRUE));

        assertThat(response.getCoins().get(1).getBlockchains().get(1).getCode(), is("MATIC"));
        assertThat(response.getCoins().get(1).getBlockchains().get(1).getDescription(), is("Polygon"));
        assertThat(response.getCoins().get(1).getBlockchains().get(1).getIsDefault(), is(Boolean.FALSE));
    }

    @Test
    public void testGetCountries() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/countries", null))
                .thenReturn(new BanxaClientResponse(200, "{\"data\":{\"countries\":[{\"country_code\":\"AU\",\"country_name\":\"Australia\"},{\"country_code\":\"US\",\"country_name\":\"United States\"}]}}"));

        BanxaService service = new BanxaServiceImpl(client);
        GetCountriesResponse response = service.getCountries(new GetCountriesRequest());

        assertThat(response.getCountries().size(), is(2));
        assertThat(response.getCountries().get(0).getCountryCode(), is("AU"));
        assertThat(response.getCountries().get(0).getCountryName(), is("Australia"));
        assertThat(response.getCountries().get(1).getCountryCode(), is("US"));
        assertThat(response.getCountries().get(1).getCountryName(), is("United States"));
    }

    @Test
    public void testGetUsStates() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/countries/us/states", null))
                .thenReturn(new BanxaClientResponse(200, "{\"data\":{\"states\":[{\"state_code\":\"AL\",\"state_name\":\"Alabama\"},{\"state_code\":\"AK\",\"state_name\":\"Alaska\"}]}}"));

        BanxaService service = new BanxaServiceImpl(client);
        GetUsStatesResponse response = service.getUsStates(new GetUsStatesRequest());

        assertThat(response.getStates().size(), is(2));
        assertThat(response.getStates().get(0).getStateCode(), is("AL"));
        assertThat(response.getStates().get(0).getStateName(), is("Alabama"));
        assertThat(response.getStates().get(1).getStateCode(), is("AK"));
        assertThat(response.getStates().get(1).getStateName(), is("Alaska"));
    }

    @Test
    public void testPaymentMethods() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/payment-methods?source=AUD", null))
                .thenReturn(new BanxaClientResponse(200, "{\"data\":{\"payment_methods\":[" +
                        "{\"id\":5021,\"paymentType\":\"POLI\",\"name\":\"POLi\",\"description\":\"POLi Payments allow you to buy digital currency by bank transfer using your internet banking\",\"logo_url\":\"https:\\/\\/jeffjeff.banxa.com\\/images\\/payment-providers\\/poli.png\",\"status\":\"ACTIVE\",\"supported_agents\":null,\"type\":\"FIAT_TO_CRYPTO\",\"supported_fiat\":[\"AUD\"],\"supported_coin\":[\"BTC\",\"ETH\",\"USDT\"],\"transaction_fees\":[{\"fiat_code\":\"AUD\",\"coin_code\":\"BTC\",\"fees\":[]},{\"fiat_code\":\"AUD\",\"coin_code\":\"ETH\",\"fees\":[]}],\"transaction_limits\":[{\"fiat_code\":\"AUD\",\"min\":\"2\",\"max\":\"50000\"}]}," +
                        "{\"id\":5035,\"paymentType\":\"NPP\",\"name\":\"PayID\",\"description\":\"PayID is a payment method which allows you to make a near\\u2011instant deposit from your Australian bank account to buy digital currency\",\"logo_url\":\"https:\\/\\/jeffjeff.banxa.com\\/images\\/payment-providers\\/npp.png\",\"status\":\"ACTIVE\",\"supported_agents\":null,\"type\":\"FIAT_TO_CRYPTO\",\"supported_fiat\":[\"AUD\"],\"supported_coin\":[\"BTC\",\"ETH\",\"USDT\"],\"transaction_fees\":[{\"fiat_code\":\"AUD\",\"coin_code\":\"BTC\",\"fees\":[]},{\"fiat_code\":\"AUD\",\"coin_code\":\"ETH\",\"fees\":[]}],\"transaction_limits\":[{\"fiat_code\":\"AUD\",\"min\":\"2\",\"max\":\"50000\"}]}" +
                        "]}}"));

        BanxaService service = new BanxaServiceImpl(client);
        GetPaymentMethodsResponse response = service.getPaymentMethods(new GetPaymentMethodsRequest.Builder().withSource("AUD").build());

        assertThat(response.getPaymentMethods().size(), is(2));
        assertThat(response.getPaymentMethods().get(0).getId(), is(5021));
        assertThat(response.getPaymentMethods().get(0).getName(), is("POLi"));
        assertThat(response.getPaymentMethods().get(0).getDescription(), is("POLi Payments allow you to buy digital currency by bank transfer using your internet banking"));
        assertThat(response.getPaymentMethods().get(0).getLogoUrl(), is("https://jeffjeff.banxa.com/images/payment-providers/poli.png"));
        assertThat(response.getPaymentMethods().get(0).getStatus(), is("ACTIVE"));
        assertThat(response.getPaymentMethods().get(0).getType(), is("FIAT_TO_CRYPTO"));
        assertThat(response.getPaymentMethods().get(0).getSupportedAgents(), is(nullValue()));
        assertThat(response.getPaymentMethods().get(0).getSupportedFiat(), is(List.of("AUD")));
        assertThat(response.getPaymentMethods().get(0).getSupportedCoin(), is(List.of("BTC", "ETH", "USDT")));
        assertThat(response.getPaymentMethods().get(0).getTransactionFees(), is(List.of(
                new TransactionFee("AUD", "BTC", Collections.emptyList()),
                new TransactionFee("AUD", "ETH", Collections.emptyList()))));
        assertThat(response.getPaymentMethods().get(0).getTransactionLimits(), is(List.of(
                new TransactionLimit("AUD", 2.0, 50000.0)
        )));
    }

    @Test
    public void testPrices() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/prices?payment_method_id=5021&source=AUD&source_amount=100.0&target=BTC", null))
                .thenReturn(new BanxaClientResponse(200, "{\"data\":{\"spot_price\":\"32681.87\",\"prices\":[{\"payment_method_id\":5021,\"type\":\"FIAT_TO_CRYPTO\",\"spot_price_fee\":\"0.00\",\"spot_price_including_fee\":\"32681.87\",\"coin_amount\":\"0.00305980\",\"coin_code\":\"BTC\",\"fiat_amount\":\"100.00\",\"fiat_code\":\"AUD\",\"fee_amount\":\"0.00\",\"network_fee\":\"0.19\"}]}}"));

        BanxaService service = new BanxaServiceImpl(client);
        GetPricesResponse response = service.getPrices(new GetPricesRequest.Builder("AUD", "BTC").withPaymentMethodId(5021).withSourceAmount(100.0).build());

        assertThat(response.getSpotPrice(), is("32681.87"));
        assertThat(response.getPrices().size(), is(1));
        assertThat(response.getPrices().get(0).getPaymentMethodId(), is(5021));
        assertThat(response.getPrices().get(0).getType(), is("FIAT_TO_CRYPTO"));
        assertThat(response.getPrices().get(0).getSpotPriceFee(), is("0.00"));
        assertThat(response.getPrices().get(0).getSpotPriceIncludingFee(), is("32681.87"));
        assertThat(response.getPrices().get(0).getCoinAmount(), is("0.00305980"));
        assertThat(response.getPrices().get(0).getCoinCode(), is("BTC"));
        assertThat(response.getPrices().get(0).getFiatAmount(), is("100.00"));
        assertThat(response.getPrices().get(0).getFiatCode(), is("AUD"));
        assertThat(response.getPrices().get(0).getFeeAmount(), is("0.00"));
        assertThat(response.getPrices().get(0).getNetworkFee(), is("0.19"));
    }

    @Test(expected = BanxaException.class)
    public void testPricesWithInvalidSourceCurrency() throws Exception {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/prices?payment_method_id=5021&source=AUDD&source_amount=100.0&target=BTC", null))
                .thenReturn(new BanxaClientResponse(422, "{\"errors\":[{\"status\":\"422\",\"title\":\"Invalid Parameters\",\"detail\":{\"source\":\"The currency AUDD is not available.\"}}]}"));

        BanxaService service = new BanxaServiceImpl(client);
        GetPricesResponse response = service.getPrices(new GetPricesRequest.Builder("AUDD", "BTC").withPaymentMethodId(5021).withSourceAmount(100.0).build());
    }

    @Test
    public void testCreateBuyOrder() throws BanxaException {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("POST", "/api/orders", "{\"account_reference\":\"TEST_1234\",\"source\":\"AUD\",\"source_amount\":\"50.0\",\"target\":\"USDT\",\"return_url_on_success\":\"http://test.com\",\"wallet_address\":\"0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78\"}"))
                .thenReturn(new BanxaClientResponse(200, "{\"data\":{\"order\":{\"id\":\"abcd1234\",\"account_id\":\"7cbfd31a2880c82deb\",\"account_reference\":\"TEST_1234\",\"order_type\":\"CRYPTO-BUY\",\"payment_type\":\"WORLDPAYGIV\",\"ref\":7552354,\"fiat_code\":\"AUD\",\"fiat_amount\":50,\"coin_code\":\"USDT\",\"coin_amount\":32.209,\"wallet_address\":\"0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78\",\"wallet_address_tag\":null,\"fee\":0,\"fee_tax\":0,\"payment_fee\":1.07,\"payment_fee_tax\":0.09,\"commission\":0,\"tx_hash\":\"0xa69e0618dec79e5cfb039994d360455e9a85459394792ceaf78a7308b0a29c52\",\"tx_confirms\":10,\"created_date\":\"01-Sep-2022\",\"created_at\":\"01-Sep-2022 05:31:26\",\"status\":\"complete\",\"completed_at\":\"01-Sep-2022 06:23:42\",\"merchant_fee\":0,\"merchant_commission\":0,\"meta_data\":null,\"blockchain\":{\"id\":3,\"code\":\"ETH\",\"description\":\"Ethereum (ERC20)\"}}}}\n"));

        BanxaService service = new BanxaServiceImpl(client);
        CreateBuyOrderResponse response = service.createBuyOrder(new CreateBuyOrderRequest.Builder("TEST_1234", "AUD", "USDT", "0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78", "http://test.com").withSourceAmount("50.0").build());

        assertThat(response.getOrder().getId(), is("abcd1234"));
    }

    @Test
    public void testCreateSellOrder() throws BanxaException {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("POST", "/api/orders", "{\"account_reference\":\"TEST_1234\",\"source\":\"AUD\",\"target\":\"USDT\",\"target_amount\":\"50.0\",\"return_url_on_success\":\"http://test.com\",\"refund_address\":\"0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78\"}"))
                .thenReturn(new BanxaClientResponse(200, "{\"data\":{\"order\":{\"id\":\"abcd1234\",\"account_id\":\"7cbfd31a2880c82deb\",\"account_reference\":\"TEST_1234\",\"order_type\":\"CRYPTO-SELL\",\"payment_type\":\"WORLDPAYGIV\",\"ref\":7552354,\"fiat_code\":\"AUD\",\"fiat_amount\":50,\"coin_code\":\"USDT\",\"coin_amount\":32.209,\"wallet_address\":\"0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78\",\"wallet_address_tag\":null,\"fee\":0,\"fee_tax\":0,\"payment_fee\":1.07,\"payment_fee_tax\":0.09,\"commission\":0,\"tx_hash\":\"0xa69e0618dec79e5cfb039994d360455e9a85459394792ceaf78a7308b0a29c52\",\"tx_confirms\":10,\"created_date\":\"01-Sep-2022\",\"created_at\":\"01-Sep-2022 05:31:26\",\"status\":\"complete\",\"completed_at\":\"01-Sep-2022 06:23:42\",\"merchant_fee\":0,\"merchant_commission\":0,\"meta_data\":null,\"blockchain\":{\"id\":3,\"code\":\"ETH\",\"description\":\"Ethereum (ERC20)\"}}}}\n"));

        BanxaService service = new BanxaServiceImpl(client);
        CreateSellOrderResponse response = service.createSellOrder(new CreateSellOrderRequest.Builder("TEST_1234", "AUD", "USDT", "0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78", "http://test.com").withTargetAmount("50.0").build());

        assertThat(response.getOrder().getId(), is("abcd1234"));
    }

    @Test
    public void testCreateNFTOrder() throws BanxaException {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("POST", "/api/orders/nft/buy", "{\"account_reference\":\"TEST_1234\",\"source\":\"AUD\",\"source_amount\":\"50.0\",\"target\":\"USDT\",\"target_amount\":\"50.0\",\"return_url_on_success\":\"http://test.com\",\"meta_data\":{\"purchase_reference\":\"REF_1\",\"nft\":{\"name\":\"NFT_1\",\"collection\":\"COL_1\",\"media\":{\"type\":\"image\",\"link\":\"http://example.com\"}}},\"wallet_address\":\"0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78\"}"))
                .thenReturn(new BanxaClientResponse(200, "{\"data\":{\"order\":{\"id\":\"abcd1234\",\"account_id\":\"7cbfd31a2880c82deb\",\"account_reference\":\"TEST_1234\",\"order_type\":\"CRYPTO-SELL\",\"payment_type\":\"WORLDPAYGIV\",\"ref\":7552354,\"fiat_code\":\"AUD\",\"fiat_amount\":50,\"coin_code\":\"USDT\",\"coin_amount\":32.209,\"wallet_address\":\"0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78\",\"wallet_address_tag\":null,\"fee\":0,\"fee_tax\":0,\"payment_fee\":1.07,\"payment_fee_tax\":0.09,\"commission\":0,\"tx_hash\":\"0xa69e0618dec79e5cfb039994d360455e9a85459394792ceaf78a7308b0a29c52\",\"tx_confirms\":10,\"created_date\":\"01-Sep-2022\",\"created_at\":\"01-Sep-2022 05:31:26\",\"status\":\"complete\",\"completed_at\":\"01-Sep-2022 06:23:42\",\"merchant_fee\":0,\"merchant_commission\":0,\"meta_data\":null,\"blockchain\":{\"id\":3,\"code\":\"ETH\",\"description\":\"Ethereum (ERC20)\"}}}}\n"));

        BanxaService service = new BanxaServiceImpl(client);
        CreateNftOrderResponse response = service.createNftOrder(new CreateNftOrderRequest.Builder("TEST_1234", "AUD", "50.0", "USDT", "0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78", "http://test.com",
                new NftMetaData.Builder("REF_1",
                        new Nft.Builder("NFT_1", "COL_1",
                                new NftMedia.Builder("image", "http://example.com").build()).build()).build())
                .withTargetAmount("50.0").build());

        assertThat(response.getOrder().getId(), is("abcd1234"));
    }

    @Test
    public void testCreateIdentity() throws BanxaException {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("POST", "/api/identities", "{\"account_reference\":\"TEST_1234\",\"mobile_number\":\"61431000001\",\"email\":\"test@test.com\",\"customer_identity\":{\"given_name\":\"Joe\",\"surname\":\"Bloggs\",\"residential_address\":{\"country\":\"AU\"}},\"identity_documents\":[{\"type\":\"DRIVING_LICENSE\",\"images\":[{\"link\":\"https://example.com/example.png\"}],\"data\":{\"number\":\"12345\"}}],\"identity_sharing\":[{\"provider\":\"sumsub\",\"token\":\"TOKEN123\"}]}"))
                .thenReturn(new BanxaClientResponse(200, "{\"data\":{\"account\":{\"account_id\":\"7cbfd31a2880c82deb\",\"account_reference\":\"TEST_1234\"}}}"));

        BanxaService service = new BanxaServiceImpl(client);
        CreateIdentityResponse response = service.createIdentity(new CreateIdentityRequest.Builder(
                "TEST_1234",
                "61431000001",
                "test@test.com"
        )
                .withCustomerIdentity(new CustomerIdentity.Builder("Joe", "Bloggs",
                        new ResidentialAddress.Builder("AU").build()).build())
                .addIdentityDocuments(new IdentityDocument.Builder(IdentityDocumentType.DRIVING_LICENSE)
                        .withData(new IdentityDocumentData("12345"))
                        .addImage(new IdentityDocumentImage("https://example.com/example.png"))
                        .build())
                .addIdentitySharing(new IdentitySharing.Builder("sumsub", "TOKEN123").build())
                .build());

        assertThat(response.getAccount().getAccountReference(), is("TEST_1234"));
    }

    @Test
    public void testGetOrder() throws BanxaException {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/orders/abcd1234", null))
                .thenReturn(new BanxaClientResponse(200, "{\"data\":{\"order\":{\"id\":\"abcd1234\",\"account_id\":\"7cbfd31a2880c82deb\",\"account_reference\":\"TEST_1234\",\"order_type\":\"CRYPTO-BUY\",\"payment_type\":\"WORLDPAYGIV\",\"ref\":7552354,\"fiat_code\":\"AUD\",\"fiat_amount\":50,\"coin_code\":\"USDT\",\"coin_amount\":32.209,\"wallet_address\":\"0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78\",\"wallet_address_tag\":null,\"fee\":0,\"fee_tax\":0,\"payment_fee\":1.07,\"payment_fee_tax\":0.09,\"commission\":0,\"tx_hash\":\"0xa69e0618dec79e5cfb039994d360455e9a85459394792ceaf78a7308b0a29c52\",\"tx_confirms\":10,\"created_date\":\"01-Sep-2022\",\"created_at\":\"01-Sep-2022 05:31:26\",\"status\":\"complete\",\"completed_at\":\"01-Sep-2022 06:23:42\",\"merchant_fee\":0,\"merchant_commission\":0,\"meta_data\":null,\"blockchain\":{\"id\":3,\"code\":\"ETH\",\"description\":\"Ethereum (ERC20)\"}}}}\n"));

        BanxaService service = new BanxaServiceImpl(client);
        GetOrderResponse response = service.getOrder(new GetOrderRequest.Builder("abcd1234").build());

        assertThat(response.getOrder().getId(), is("abcd1234"));
    }

    @Test
    public void testConfirmSellOrder() throws BanxaException {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("POST", "/api/orders/abcd1234/confirm", "{\"tx_hash\":\"0xa69e0618dec79e5cfb039994d360455e9a85459394792ceaf78a7308b0a29c52\",\"source_address\":\"0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78\",\"destination_address\":\"0x55ccd212a6fcb8392ed47ac7fec0a82c51605f11\"}"))
                .thenReturn(new BanxaClientResponse(200, "{\"data\":{\"order\":{\"id\":\"abcd1234\",\"account_id\":\"7cbfd31a2880c82deb\",\"account_reference\":\"TEST_1234\",\"order_type\":\"CRYPTO-SELL\",\"payment_type\":\"WORLDPAYGIV\",\"ref\":7552354,\"fiat_code\":\"AUD\",\"fiat_amount\":50,\"coin_code\":\"USDT\",\"coin_amount\":32.209,\"wallet_address\":\"0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78\",\"wallet_address_tag\":null,\"fee\":0,\"fee_tax\":0,\"payment_fee\":1.07,\"payment_fee_tax\":0.09,\"commission\":0,\"tx_hash\":\"0xa69e0618dec79e5cfb039994d360455e9a85459394792ceaf78a7308b0a29c52\",\"tx_confirms\":10,\"created_date\":\"01-Sep-2022\",\"created_at\":\"01-Sep-2022 05:31:26\",\"status\":\"complete\",\"completed_at\":\"01-Sep-2022 06:23:42\",\"merchant_fee\":0,\"merchant_commission\":0,\"meta_data\":null,\"blockchain\":{\"id\":3,\"code\":\"ETH\",\"description\":\"Ethereum (ERC20)\"}}}}\n"));

        BanxaService service = new BanxaServiceImpl(client);
        ConfirmSellOrderResponse response = service.confirmSellOrder(new ConfirmSellOrderRequest.Builder("abcd1234", "0xa69e0618dec79e5cfb039994d360455e9a85459394792ceaf78a7308b0a29c52", "0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78", "0x55ccd212a6fcb8392ed47ac7fec0a82c51605f11").build());

        assertThat(response.getOrder().getId(), is("abcd1234"));
    }

    @Test
    public void testGetOrders() throws BanxaException {
        BanxaClient client = Mockito.mock(BanxaClient.class);
        when(client.request("GET", "/api/orders?end_date=2022-09-28&page=1&per_page=1&start_date=2022-09-01", null))
                .thenReturn(new BanxaClientResponse(200, "{\"data\":{\"orders\":[{\"id\":\"abcd1234\",\"account_id\":\"7cbfd31a2880c82deb\",\"account_reference\":\"TEST_1234\",\"order_type\":\"CRYPTO-BUY\",\"payment_type\":\"WORLDPAYGIV\",\"ref\":7552354,\"fiat_code\":\"AUD\",\"fiat_amount\":50,\"coin_code\":\"USDT\",\"coin_amount\":32.209,\"wallet_address\":\"0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78\",\"wallet_address_tag\":null,\"fee\":0,\"fee_tax\":0,\"payment_fee\":1.07,\"payment_fee_tax\":0.09,\"commission\":0,\"tx_hash\":\"0xa69e0618dec79e5cfb039994d360455e9a85459394792ceaf78a7308b0a29c52\",\"tx_confirms\":10,\"created_date\":\"01-Sep-2022\",\"created_at\":\"01-Sep-2022 05:31:26\",\"status\":\"complete\",\"completed_at\":\"01-Sep-2022 06:23:42\",\"merchant_fee\":0,\"merchant_commission\":0,\"meta_data\":null,\"blockchain\":{\"id\":3,\"code\":\"ETH\",\"description\":\"Ethereum (ERC20)\"}}]},\"meta\":{\"current_page\":1,\"from\":1,\"last_page\":2,\"per_page\":1,\"to\":1,\"total\":2}}"));

        when(client.request("GET", "/api/orders?end_date=2022-09-28&page=2&per_page=1&start_date=2022-09-01", null))
                .thenReturn(new BanxaClientResponse(200, "{\"data\":{\"orders\":[{\"id\":\"bcde2345\",\"account_id\":\"7cbfd31a2880c82deb\",\"account_reference\":\"TEST_1234\",\"order_type\":\"CRYPTO-BUY\",\"payment_type\":\"WORLDPAYGIV\",\"ref\":7552354,\"fiat_code\":\"AUD\",\"fiat_amount\":50,\"coin_code\":\"USDT\",\"coin_amount\":32.209,\"wallet_address\":\"0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78\",\"wallet_address_tag\":null,\"fee\":0,\"fee_tax\":0,\"payment_fee\":1.07,\"payment_fee_tax\":0.09,\"commission\":0,\"tx_hash\":\"0xa69e0618dec79e5cfb039994d360455e9a85459394792ceaf78a7308b0a29c52\",\"tx_confirms\":10,\"created_date\":\"01-Sep-2022\",\"created_at\":\"01-Sep-2022 05:31:26\",\"status\":\"complete\",\"completed_at\":\"01-Sep-2022 06:23:42\",\"merchant_fee\":0,\"merchant_commission\":0,\"meta_data\":null,\"blockchain\":{\"id\":3,\"code\":\"ETH\",\"description\":\"Ethereum (ERC20)\"}}]},\"meta\":{\"current_page\":2,\"from\":2,\"last_page\":2,\"per_page\":1,\"to\":2,\"total\":2}}"));

        BanxaService service = new BanxaServiceImpl(client);
        GetOrdersRequest request = new GetOrdersRequest.Builder(LocalDate.of(2022, 9, 1), LocalDate.of(2022, 9, 28)).withPerPage(1).build();
        GetOrdersResponse response = service.getOrders(request);
        assertThat(response.getOrders().get(0).getId(), is("abcd1234"));

        assertThat(response.getPagination(), is(notNullValue()));
        assertThat(response.getPagination().getFrom(), is(1));
        assertThat(response.getPagination().getTo(), is(1));
        assertThat(response.getPagination().getTotal(), is(2));
        assertThat(response.getPagination().getCurrentPage(), is(1));
        assertThat(response.getPagination().getLastPage(), is(2));
        assertThat(response.getPagination().getPerPage(), is(1));
        assertThat(response.getPagination().isLastPage(), is(false));

        request.nextPage();
        response = service.getOrders(request);
        assertThat(response.getOrders().get(0).getId(), is("bcde2345"));

        assertThat(response.getPagination().isLastPage(), is(true));

    }
//
//    public void testTemplate() throws Exception {
//        BanxaClient client = Mockito.mock(BanxaClient.class);
//        when(client.request("GET", "/api/payment-methods", null))
//                .thenReturn(new BanxaClientResponse(200, ""));
//
//        BanxaService service = new BanxaServiceImpl(client);
//        BanxaResponse<GetFiatCurrenciesResponse> response = service.request(new GetFiatCurrenciesRequest(OrderType.BUY));
//
//        assertThat(response.isSuccess(), is(Boolean.TRUE));
//        assertThat(response.getResponse().getFiats().size(), is(2));
//        assertThat(response.getResponse().getFiats().get(0).getFiatCode(), is("AUD"));
//    }

}
