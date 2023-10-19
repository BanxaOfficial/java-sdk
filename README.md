![Banxa](https://banxa.com/wp-content/uploads/2022/02/image-16.png)

## Banxa official Java SDK

## Table of Contents

<!-- TOC -->

* [General info](#general-info)
    * [Installation](#installation)
    * [Authentication](#authentication)
        * [Domain, ApiKey and ApiSecret](#apikey-and-apisecret)
    * [Dependencies](#dependencies)
    * [Usage](#usage)
        * [Sandbox](#sandbox)
        * [Production](#production)
* [Localisation](#localisation)
    * [Countries](#countries)
    * [US States](#us-states)
* [Currencies](#currencies)
    * [Fiat](#fiat)
    * [Crypto](#crypto)
* [Payment Methods](#payment-methods)
    * [Buy & Sell order type](#buy--sell-order-type-payment-methods)
    * [Buy order type](#buy-order-type-payment-methods)
    * [Sell order type](#sell-order-type-payment-methods)
* [Prices](#prices)
    * [Buy order types](#buy-order-types-pricing)
    * [Buy order type](#buy-order-type-pricing)
    * [Sell order types](#sell-order-types-pricing)
    * [Sell order type](#sell-order-type-pricing)
* [Orders](#orders)
    * [Retrieving Order(s)](#retrieving-orders)
        * [Fetch orders](#fetch-orders)
        * [Fetch order](#fetch-order)
    * [Order creation](#creating-orders)
        * [Creating a buy order](#creating-a-buy-order)
        * [Creating a NFT buy order](#creating-a-nft-buy-order)
        * [Creating a sell order](#creating-a-sell-order)
    * [Confirm sell order](#confirm-sell-order)
* [Identity](#identity)
    * [Create Identity](#create-identity)

<!-- TOC -->

# General info

The Banxa SDK is a plug and play ready to go implementation to access our services.   
It allows for a simple and fast integration.

# Installation

Install the package via maven

```
    <dependency>
      <groupId>com.banxa</groupId>
      <artifactId>java-sdk</artifactId>
      <version>1.2.0</version>
    </dependency> 
```

# Authentication

## ApiKey and ApiSecret

While on-boarding with banxa, you will be provided with API keys and a subdomain ([partnername].banxa.com),   
initially these will be for the sandbox environment.
Once you are done testing the implementation, you will receive the credentials to use for the production environment.

# Dependencies

| Java | Jackson |
|------|---------|
| ^11  | ^2.14   |

# Usage

```java
BanxaClient client = new BanxaClientImpl(
        subdomain,
        apiKey,
        apiSecret,
        testMode);

BanxaService service = new BanxaServiceImpl(client);
```

| Property    | type     | required | description                                                                 |
|-------------|----------|----------|-----------------------------------------------------------------------------|
| `subdomain` | `string` | `true`   | The subdomain provided by banxa. ([partnername] of [partnername].banxa.com) |
| `apiKey`    | `string` | `true`   | Given API key                                                               |
| `apiSecret` | `string` | `true`   | Given API Secret                                                            |
| `testMode`  | `bool`   | `false`  | Enable if testing, and provide sandbox api key and secret to constructor    |

### Source & Target
Throughout the SDK you will see source & target and sourceAmount & targetAmount. Depending on whether the customer is doing a buy or a sell order will dictate how these should be set.

For a buy order, the source should be a fiat code and the target should be a coin code. For a sell order, the source should be a coin code and the target should be a fiat code. 

With the amounts, you should only set one of these based on which the customer is entering on your platform and the order type.

If the order type is buy and the customer is providing the fiat amount, then sourceAmount should be set. If the customer is providing the crypto amount, then targetAmount should be set

If the order type is sell, then the inverse should be used.

---



# Requests

## Countries
 ### Global
> **Fetch all available countries**
>```java
> try { 
>   GetCountriesResponse response = banxaService.getCountries(new GetCountriesRequest.Builder().build());
>   response.getCountries().forEach(country -> {
>       // process country
>   });
> } catch (BanxaException e) {
>   // process exception
> }
>```

### US States

> **Fetch all available US States**
> 
> ```java
> try { 
>   GetUsStatesResponse response = banxaService.getUsStates(new GetUsStatesRequest.Builder().build());
>   response.getStates().forEach(state -> {
>       // process state
>   });
> } catch (BanxaException e) {
>   // process exception
> }
>```

---

# Currencies

## Fiat

> ### Buy order type
> **Fetch all available fiat currencies for buy order type.**
>
>```java
> try { 
>   GetFiatCurrenciesResponse response = banxaService.getFiatCurrencies(GetFiatCurrenciesRequest.createBuyBuilder().build());
>   response.getFiats().forEach(fiat -> {
>       // process fiat
>   });
> } catch (BanxaException e) {
>   // process exception
> }
>```
> ### Sell order type
> **Fetch all available fiat currencies for sell order type.**
>```java
> try { 
>   GetFiatCurrenciesResponse response = banxaService.getFiatCurrencies(GetFiatCurrenciesRequest.createSellBuilder().build());
>   response.getFiats().forEach(fiat -> {
>       // process fiat
>   });
> } catch (BanxaException e) {
>   // process exception
> }
>```

---

## Crypto

> ### Buy order type
> **Fetch all cryptocurrencies for buy order type.**
>
>```java
> try { 
>   GetCryptoCurrenciesResponse response = banxaService.getCryptoCurrencies(GetCryptoCurrenciesRequest.createBuyBuilder().build());
>   response.getCoins().forEach(coin -> {
>       // process coin
>   });
> } catch (BanxaException e) {
>   // process exception
> }
>```
> ### Sell order type
> **Fetch all cryptocurrencies for sell-order type.**
> 
>```java
> try { 
>   GetCryptoCurrenciesResponse response = banxaService.getCryptoCurrencies(GetCryptoCurrenciesRequest.createSellBuilder().build());
>   response.getCoins().forEach(coin -> {
>       // process coin
>   });
> } catch (BanxaException e) {
>   // process exception
> }
>```

---

# Payment Methods

### Buy & Sell order type payment methods

> **Fetch all available payment providers** 
>```java
> try {
>     GetPaymentMethodsResponse response = banxaService.getPaymentMethods(GetPaymentMethodsRequest.createBuyBuilder("USD", "USDT").build());
>     response.getPaymentMethods().forEach(paymentMethod -> {
>         // process payment method
>     });
> } catch (BanxaException e) {
>     // process exception
> }
>```
>
> Using the `createBuyBuilder` or `createSellBuilder` helper methods sets the `source` and `target` in the builder

### Properties

| Property | type     | required | description                                                                                                                         |
|----------|----------|----------|-------------------------------------------------------------------------------------------------------------------------------------|
| `source` | `string` | `true`   | What the customer is converting from, either Fiat or Coin code see [Fiat](#fiat) or [Crypto](#crypto) for list of available options |
| `target` | `string` | `true`   | What the customer is converting to, either Fiat or Coin code see [Fiat](#fiat) or [Crypto](#crypto) for list of available options   |

--- 

# Prices

Get prices for [Payment Methods](#payment-methods) to obtain a payment method id for each specific fiat.

### Buy & Sell order type pricing

> **Fetch all available prices for buy or sell order type**
>```java
> try {
>     GetPricesResponse response = banxaService.getPrices(GetPricesRequest.createBuyBuilder("USD", "USDT").withSourceAmount(100.0).build());
>     response.getPrices().forEach(price -> {
>         // process price
>     });
> } catch (BanxaException e) {
>     // process exception
> }
>```
>
> Using the `createBuyBuilder` or `createSellBuilder` helper methods sets the `source` and `target` in the builder. Passing the `paymentMethodId` will filter the results to just 1 payment. Excluding will return all payment options for the fiat/crypto pair. See below for other available properties
 
| Property          | description | required | description                                                                                                                                   |
|:------------------|:------------|:---------|:----------------------------------------------------------------------------------------------------------------------------------------------|
| `source`          | `string`    | `true`   | What the customer is converting from, either Fiat or Coin code see [Fiat](#fiat) or [Crypto](#crypto) for list of available options           |
| `target`          | `string`    | `true`   | What the customer is converting to, either Fiat or Coin code see [Fiat](#fiat) or [Crypto](#crypto) for list of available options             |
| `sourceAmount`    | `double`    | `false`  | The amount the customer would like to spend / send. Setting this will lock the order by the source amount                                     |
| `targetAmount`    | `double`    | `false`  | The amount the customer would like to receive. Setting this will lock the order by the target amount                                          |
| `paymentMethodId` | `int`       | `false`  | Unique ID for the payment method that you want to get prices for. see [Payment Methods](#payment-methods) to get a list of payment providers. |
| `blockchain`      | `string`    | `false`  | Blockchain code e.g. 'ETH' or 'TRON' see [Crypto](#crypto) to get a list all available blockchains per coin.                                  |

---

# Orders

## Retrieving orders

### Fetch orders

> **Fetch all orders within a specific time range. (paginated)**
>```java
> try {
>     GetOrdersRequest getOrdersRequest = new GetOrdersRequest.Builder(LocalDate.of(2022, 9, 1), LocalDate.of(2022, 9, 28))
>             .addStatus(OrderStatus.COMPLETE)
>             .withPerPage(100).build();
>     boolean done = false;
>     while (!done) {
>         GetOrdersResponse response = banxaService.getOrders(getOrdersRequest);
>         response.getOrders().forEach(order -> {
>             // process the order
>         });
>         if (response.getPagination().isLastPage()) {
>             done = true;
>         } else {
>             getOrdersRequest.nextPage();
>         }
>     }
> } catch (BanxaException e) {
>     // process exception
> }
>```

| Property           | type          | required | description                                                                                                           |
|:-------------------|:--------------|:---------|:----------------------------------------------------------------------------------------------------------------------|
| `startDate`        | `LocalDate`   | `true`   | Start date used for filtering orders                                                                                  |
| `endDate`          | `LocalDate`   | `true`   | End date used for filtering orders                                                                                    |
| `status`           | `OrderStatus` | `false`  | One or many order statuses (see 'Available Statuses')                                                                 |
| `perPage`          | `int`         | `false`  | Page size.                                                                                                            |
| `page`             | `int`         | `false`  | Page to retrieve.                                                                                                     |
| `accountReference` | `string`      | `false`  | Customer reference that was passed as a parameter when creating an order. Used to retrieve all orders for a customer. |

| Available Statuses             |
|:-------------------------------|
| `OrderStatus.PENDING_PAYMENT`  |
| `OrderStatus.WAITING_PAYMENT`  |
| `OrderStatus.PAYMENT_RECEIVED` |
| `OrderStatus.IN_PROGRESS`      |
| `OrderStatus.COIN_TRANSFERRED` |
| `OrderStatus.CANCELLED`        |
| `OrderStatus.DECLINED`         |
| `OrderStatus.EXPIRED`          |
| `OrderStatus.COMPLETE`         |
| `OrderStatus.REFUNDED`         |

---

### Fetch order

> **Fetch single order**
>```java
> try {
>     GetOrderResponse response = banxaService.getOrder(new GetOrderRequest.Builder("[ORDER_ID]").build());
>     response.getOrder();
> } catch (BanxaException e) {
>     // process exception
> }
>```

| Property  | description | required | description                        |
|:----------|:------------|:---------|:-----------------------------------|
| `orderId` | `string`    | `true`   | Unique ID of the order to retrieve |

---

## Creating orders

Allows your customer to create a buy or sell crypto order with Banxa. Upon success, the response will contain a checkout
URL which will be unique for the order. The customer should be redirected to this URL to complete the checkout process,
which will expire after 1 minute if a redirect does not occur.

For a buy order, if the customer is wanting to set the spend amount, then only set the sourceAmount. Alternatively setting the targetAmount will set the amount to receive in the chosen coin.

The inverse is true for a sell order.

### Creating a buy order

> ```java
> CreateBuyOrderResponse response = banxaService.createBuyOrder(new CreateBuyOrderRequest.Builder(
>         "TEST123",
>         "USD",
>         "USDT",
>         "0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78",
>         "https://google.com")
>         .withSourceAmount("100")
>         .build());
> 
> // redirect the customer to this URL
> String redirect = response.getOrder().getCheckoutUrl();
>```

| Property               | type       | required | description                                                                                                                                                                 |
|------------------------|------------|----------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `accountReference`     | `string`   | `true`   | The customer's unique ID                                                                                                                                                    |
| `fiatCode`             | `string`   | `true`   | Fiat code e.g. 'USD' or 'EUR' see [Fiat](#fiat) to get a list all available fiats                                                                                           |
| `coinCode`             | `string`   | `true`   | Coin code e.g. 'BTC' or 'ETH' see [Crypto](#crypto) to get a list all available crypto                                                                                      |
| `walletAddress`        | `string`   | `true`   | The target wallet address to transfer the coin to                                                                                                                           |
| `sourceAmount`         | `string`   | `false`  | The amount the customer would like to spend. Setting this will lock the order by the source amount                                                                          |
| `targetAmount`         | `string`   | `false`  | The amount the customer would like to receive. Setting this will lock the order by the target amount                                                                        |
| `paymentMethodId`      | `int`      | `false`  | Unique ID for the payment method that you want to get prices for. see [Payment Methods](#payment-methods) to get a list of payment providers.                               |
| `blockchain`           | `string`   | `false`  | Blockchain code, the list of available blockchains per coin see [Crypto](#crypto) for all available blockchains per coin                                                    |
| `walletAddressTag`     | `string`   | `false`  | Wallet tag or memo associated with the wallet address. Should be sent for buy cryptocurrency orders only for BNB (Memo) or XRP (Tag).                                       |
| `returnUrlOnSuccess`   | `string`   | `true`   | The return url on success                                                                                                                                                   | 
| `returnUrlOnFailure`   | `string`   | `false`  | The return url on failure                                                                                                                                                   | 
| `returnUrlOnCancelled` | `string`   | `false`  | The return url on cancelled                                                                                                                                                 | 
| `metadata`             | `MetaData` | `false`  | Implement the MetaData interface to send custom information that will be returned in GetOrders                                                                              | 
| `iframeDomain`         | `string`   | `false`  | Used if you are embedding an iFrame. This must be the exact domain where the iFrame will be hosted. e.g. [yourCompany].com. Do not include https:// in front of the domain. |

---

### Creating a NFT buy order

> ```java
> CreateNftOrderResponse response = banxaService.createNftOrder(new CreateNftOrderRequest.Builder(
>         "TEST123",
>         "USD",
>         "100",
>         "USDT",
>         "0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78",
>         "https://google.com",
>         new NftMetaData.Builder("REF_1", 
>                 new Nft.Builder("NFT_1", "COL_1", 
>                         new NftMedia.Builder("image", "https://example.com").build()
>                 ).build()
>         ).build()
> ).build());
> 
> String redirect = response.getOrder().getCheckoutUrl();
>```

| Property               | type          | required | description                                                                                                                                                                 |
|------------------------|---------------|----------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `accountReference`     | `string`      | `true`   | The customer's unique ID                                                                                                                                                    |
| `fiatCode`             | `string`      | `true`   | Fiat code e.g. 'USD' or 'EUR' see [Fiat](#fiat) to get a list all available fiats                                                                                           |
| `fiatAmount`           | `string`      | `true`   | The amount the customer would like to spend. Setting this will lock the order by the source amount                                                                          |
| `coinCode`             | `string`      | `true`   | Coin code e.g. 'BTC' or 'ETH' see [Crypto](#crypto) to get a list all available crypto                                                                                      |
| `walletAddress`        | `string`      | `true`   | The target wallet address to transfer the coin to                                                                                                                           |
| `metaData`             | `NftMetaData` | `true`   | `NftMetaData` object                                                                                                                                                        |
| `blockchain`           | `string`      | `false`  | Blockchain code, the list of available blockchains per coin see [Crypto](#crypto) for all available blockchains per coin                                                    |
| `paymentMethodId`      | `int`         | `false`  | Unique ID for the payment method that you want to get prices for. see [Payment Methods](#payment-methods) to get a list of payment providers.                               |
| `returnUrlOnSuccess`   | `string`      | `true`   | The return url on success                                                                                                                                                   | 
| `returnUrlOnFailure`   | `string`      | `false`  | The return url on failure                                                                                                                                                   | 
| `returnUrlOnCancelled` | `string`      | `false`  | The return url on cancelled                                                                                                                                                 | 
| `iframeDomain`         | `string`      | `false`  | Used if you are embedding an iFrame. This must be the exact domain where the iFrame will be hosted. e.g. [yourCompany].com. Do not include https:// in front of the domain. |

---

> **NftMetaData**

| Property            | type     | required | description                 |
|---------------------|----------|----------|-----------------------------|
| `purchaseReference` | `string` | `true`   | A reference of the purchase |
| `nft`               | `Nft`    | `true`   | `Nft` object                |

---
> **Nft**

| Property     | type       | required | description            |
|--------------|------------|----------|------------------------|
| `name`       | `string`   | `true`   | The name of the NFT    |
| `collection` | `string`   | `true`   | The Collection the NFT |
| `media`      | `NftMedia` | `true`   | `NftMedia` object      |

---
> **NftMedia**

| Property | type     | required | description       |
|----------|----------|----------|-------------------|
| `type`   | `string` | `true`   | image / video     |
| `link`   | `string` | `true`   | A link to the Nft |

### Creating a Sell order

> ```java
> CreateSellOrderResponse response = banxaService.createSellOrder(new CreateSellOrderRequest.Builder(
>         "TEST123",
>         "USDT",
>         "USD",
>         "0x55ccd212a6fcb8392ed47ac7fec0a82c51605f78",
>         "https://google.com")
>         .withSourceAmount("100.0")
>         .build());
>
> String redirect = response.getOrder().getCheckoutUrl();
>```

| Property               | type       | required | description                                                                                                                                                                 |
|------------------------|------------|----------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `accountReference`     | `string`   | `true`   | The customer's unique ID                                                                                                                                                    |
| `coinCode`             | `string`   | `true`   | Coin code e.g. 'BTC' or 'ETH' see [Crypto](#crypto) to get a list all available crypto                                                                                      |
| `fiatCode`             | `string`   | `true`   | Fiat code e.g. 'USD' or 'EUR' see [Fiat](#fiat) to get a list all available fiats                                                                                           |
| `walletAddress`        | `string`   | `true`   | The target wallet address to transfer the coin to                                                                                                                           |
| `sourceAmount`         | `string`   | `false`  | The amount the customer would like to send. Setting this will lock the order by the source amount                                                                           |
| `targetAmount`         | `string`   | `false`  | The amount the customer would like to receive. Setting this will lock the order by the target amount                                                                        |
| `paymentMethodId`      | `int`      | `false`  | Unique ID for the payment method that you want to get prices for. see [Payment Methods](#payment-methods) to get a list of payment providers.                               |
| `blockchain`           | `string`   | `false`  | Blockchain code, the list of available blockchains per coin see [Crypto](#crypto) for all available blockchains per coin                                                    |
| `walletAddressTag`     | `string`   | `false`  | Wallet tag or memo associated with the wallet address. Should be sent for buy cryptocurrency orders only for BNB (Memo) or XRP (Tag).                                       |
| `returnUrlOnSuccess`   | `string`   | `true`   | The return url on success                                                                                                                                                   | 
| `returnUrlOnFailure`   | `string`   | `false`  | The return url on failure                                                                                                                                                   | 
| `returnUrlOnCancelled` | `string`   | `false`  | The return url on cancelled                                                                                                                                                 | 
| `metadata`             | `MetaData` | `false`  | Implement the MetaData interface to send custom information that will be returned in GetOrders                                                                              | 
| `iframeDomain`         | `string`   | `false`  | Used if you are embedding an iFrame. This must be the exact domain where the iFrame will be hosted. e.g. [yourCompany].com. Do not include https:// in front of the domain. |

---

### Confirm sell order

> **Once the coin amount transfer for a Sell Order has been executed,    
Banxa must be notified by sending a request to this endpoint with transaction hash, source and destination wallet
address details.**
>```java
> ConfirmSellOrderResponse response = banxaService.confirmSellOrder(new ConfirmSellOrderRequest.Builder(sellOrderResponse.getOrder().getId(), txHash, sourceAddress, destinationAddress)
>       .build());
>```

| Property                | type     | required | description                                                                                         |
|-------------------------|----------|:---------|:----------------------------------------------------------------------------------------------------|
| `orderId`               | `string` | `true`   | Unique ID for the the order                                                                         |
| `txHash`                | `string` | `true`   | Blockchain transaction hash of the order                                                            |
| `sourceAddress`         | `string` | `true`   | The provided customer's source wallet address                                                       |
| `destinationAddress`    | `string` | `true`   | The wallet address provided to merchants to transact to                                             |
| `sourceAddressTag`      | `string` | `false`  | The customer's source wallet address tag if the provided source wallet address requires it          |
| `destinationAddressTag` | `string` | `false`  | The wallet address tag provided to merchants if the provided destination wallet address requires it |

---

# Identity

## Create Identity

> **Allows you to share customer details with Banxa before an Order is created.   
> This reduces the need for customers to re-submit personal details and upload KYC documentation during the Banxa
checkout
> flow.    
> Detailed guide on how to implement this API can be found [here](https://docs.banxa.com/docs/identities-service).
> You can also find Testing information [here](https://docs.banxa.com/docs/order-flow)**
>
>```java
> CreateIdentityResponse response = banxaService.createIdentity(
>         new CreateIdentityRequest.Builder("TEST123", "61431000001", "test@test.com")
>                 .withCustomerIdentity(
>                         new CustomerIdentity.Builder("Joe", "Bloggs",
>                                 new ResidentialAddress.Builder("AU").build()
>                         ).build())
>                 .addIdentityDocuments(
>                         new IdentityDocument.Builder(IdentityDocumentType.DRIVING_LICENSE)
>                                 .withData(new IdentityDocumentData("12345"))
>                                 .addImage(new IdentityDocumentImage("https://example.com/example.png"))
>                                 .build()
>                 ).build());
>```

| Property           | type               | required | description                                                                                                                                 |
|--------------------|--------------------|----------|---------------------------------------------------------------------------------------------------------------------------------------------|
| `accountReference` | `string`           | `true`   | Unique customer reference provided by you. This should be the same value that is passed when calling the calling the Create Order endpoint. |
| `mobileNumber`     | `string`           | `true`   | Mobile number of customer                                                                                                                   |
| `emailAddress`     | `string`           | `true`   | Email address of customer                                                                                                                   |
| `customerIdentity` | `CustomerIdentity` | `true`   | `CustomerIdentity` object                                                                                                                   |
| `identityDocument` | `IdentityDocument` | `false`  | `IdentityDocument` object                                                                                                                   |
| `identitySharing`  | `IdentitySharing`  | `false`  | An array of `IdentitySharing` objects. Required for Sumsub only                                                                             |


---
> **CustomerIdentity**

| Property             | type                 | required | description                                                                                                       |
|:---------------------|:---------------------|:---------|:------------------------------------------------------------------------------------------------------------------|
| `givenName`          | `string`             | `true`   | Customer's Customer's given / first name.                                                                         |
| `surname`            | `string`             | `true`   | Customer's surname / last name.                                                                                   |
| `dob`                | `string`             | `false`  | Customer's Customer's date of birth (e.g. "1985-01-31"). Required to format as ISO 8601 Date format : YYYY-MM-DD. |
| `residentialAddress` | `ResidentialAddress` | `false`  | `ResidentialAddress` object                                                                                       |

---
> **ResidentialAddress**

| Property       | type     | required | description                                                                                                         |
|:---------------|:---------|:---------|:--------------------------------------------------------------------------------------------------------------------|
| `country`      | `string` | `true`   | Customer's country of residence. Required to be formatted using ISO 3166 two-letter country code e.g. "US" or "AU". |
| `addressLine1` | `string` | `false`  | Customer's Street number, street name and street type/suffix.                                                       |
| `suburb`       | `string` | `false`  | Customer's Address city or suburb. E.g. "2 Abbey Road".                                                             |
| `postCode`     | `string` | `false`  | Customer's Address postal / PIN / ZIP code.                                                                         |
| `state`        | `string` | `false`  | Customer's Address state / region.                                                                                  |

---
> **IdentityDocument**

| Property | type                    | required                                                                 | description                                        |
|:---------|:------------------------|:-------------------------------------------------------------------------|:---------------------------------------------------|
| `type`   | `IdentityDocumentType`  | `true`                                                                   | The document type (see 'Available document types') |
| `image`  | `IdentityDocumentImage` | `true`                                                                   | `IdentityDocumentImage` object                     |
| `data`   | `IdentityDocumentData`  | `true` **when document type is PASSPORT/IDENTIFICATION/DRIVING_LICENSE** | `IdentityDocumentImage` object                     |

| Available document types                              |
|-------------------------------------------------------|
| `IdentityDocumentType.DRIVING_LICENCE`  |
| `IdentityDocumentType.PASSPORT`         |
| `IdentityDocumentType.IDENTIFICATION`   |
| `IdentityDocumentType.SELFIE`           |
| `IdentityDocumentType.PROOF_OF_ADDRESS` |


---
> **IdentityDocumentImage**

| Property | type     | required | description                             |
|:---------|:---------|:---------|:----------------------------------------|
| `link`   | `String` | `true`   | The one time link to download the image |

---
> **IdentityDocumentData**

| Property | type     | required | description         |
|:---------|:---------|:---------|:--------------------|
| `number` | `String` | `true`   | The document number |

---
> **IdentitySharing**

| Property   | type     | required | description                                                                                                                                   |
|:-----------|:---------|:---------|:----------------------------------------------------------------------------------------------------------------------------------------------|
| `provider` | `String` | `true`   | KYC provider that you have used, currently sumsub is the only supported value. Required for Sumsub only.                                      |
| `token`    | `String` | `true`   | Customer token ID that is supplied by the KYC provider that will be used by Banxa to retrieve customer KYC details. Required for Sumsub only. |
