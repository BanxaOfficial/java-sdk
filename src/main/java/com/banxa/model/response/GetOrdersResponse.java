package com.banxa.model.response;


import com.banxa.model.Order;

import java.util.List;

public class GetOrdersResponse {
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }
}
