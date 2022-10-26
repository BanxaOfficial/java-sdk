package com.banxa;

import com.banxa.client.BanxaClientImpl;
import com.banxa.model.IdentityDocumentType;
import com.banxa.model.OrderType;
import com.banxa.model.request.*;
import com.banxa.model.response.*;
import com.banxa.service.BanxaService;
import com.banxa.service.BanxaServiceImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

//        BanxaService banxaService = new BanxaServiceImpl(new BanxaClientImpl(false)        );

//        BanxaResponse<GetOrderResponse> response = banxaService.getOrder(
//                new GetOrderRequest.Builder("24e946232dd21b28e40a6d7983227a0c").build()
//        );

//        GetOrdersRequest getOrdersRequest = new GetOrdersRequest.Builder(LocalDate.of(2022, 9, 1), LocalDate.of(2022, 9, 28)).withStatus("expired").withPerPage(100).build();
//        BanxaResponse<GetOrdersResponse> response = banxaService.getOrders(getOrdersRequest);
//        if (!response.isLastPage()) {
//            getOrdersRequest.nextPage();
//            response = banxaService.getOrders(getOrdersRequest);
//        }

//        BanxaResponse<CreateBuyOrderResponse> response = banxaService.createBuyOrder(new CreateBuyOrderRequest.Builder(
//                "TEST123",
//                "AUD",
//                "BTC",
//                "1LbQ1WNTsm1Nzj1hbh3WDCbEim1oUg5rfi",
//                "https://google.com")
//                .withSourceAmount("100")
//                .build());

//        BanxaResponse<CreateSellOrderResponse> response = banxaService.createSellOrder(new CreateSellOrderRequest.Builder(
//                "TEST123",
//                "BTC",
//                "AUD",
//                "1LbQ1WNTsm1Nzj1hbh3WDCbEim1oUg5rfi",
//                "https://google.com")
//                .withSourceAmount("100")
//                .build());

//        BanxaResponse<CreateNftOrderResponse> response = banxaService.createNftOrder(new CreateNftOrderRequest.Builder(
//                "TEST123",
//                "AUD",
//                "100",
//                "USDT",
//                "0x0FDD9D5fE5eb1a4271EC95E6255cB4254A19149d",
//                "https://google.com",
//                new NftMetaData.Builder("PURCH123",
//                    new Nft.Builder("MONKEY1", "MONKEYS",
//                        new NftMedia.Builder("image", "https://test.com").build())
//                            .build())
//                        .build())
//                .build());

//        BanxaResponse<CreateIdentityResponse> response = banxaService.createIdentity(new CreateIdentityRequest.Builder(
//                "TEST123",
//                "61431000001",
//                "test@test.com"
//        )
//                .withCustomerIdentity(new CustomerIdentity.Builder("Joe", "Bloggs",
//                        new ResidentialAddress.Builder("AU").build()).build())
//                .addIdentityDocuments(new IdentityDocument.Builder(IdentityDocumentType.DRIVING_LICENSE)
//                        .withData(new IdentityDocumentData("12345"))
//                        .addImage(new IdentityDocumentImage("https://example.com/example.png"))
//                        .build())
//                .build());

//        BanxaResponse<GetCryptoCurrenciesResponse> response = banxaService.getCryptoCurrencies(new GetCryptoCurrenciesRequest.Builder(OrderType.BUY).build());
//        BanxaResponse<GetFiatCurrenciesResponse> response = banxaService.getFiatCurrencies(new GetFiatCurrenciesRequest.Builder(OrderType.BUY).build());
//        BanxaResponse<GetCountriesResponse> response = banxaService.getCountries(new GetCountriesRequest.Builder().build());
//        BanxaResponse<GetUsStatesResponse> response = banxaService.getUsStates(new GetUsStatesRequest.Builder().build());
//        BanxaResponse<GetPaymentMethodsResponse> response = banxaService.getPaymentMethods(new GetPaymentMethodsRequest.Builder().withSource("AUD").build());
//        BanxaResponse<GetPricesResponse> response = banxaService.getPrices(new GetPricesRequest.Builder("AUD", "BTC").withSourceAmount(100.0).withPaymentMethodId(5021).build());
//        BanxaResponse<GetPricesResponse> response = banxaService.getPrices(new GetPricesRequest.Builder("AUD", "BTC").withSourceAmount(100.0).build());


//        System.out.println("Done " + response.getResponse());
    }
}
