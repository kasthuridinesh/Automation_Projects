package com.atmecs.qa.pojo.Build;


import com.atmecs.qa.pojo.dto.OrderData;

public class OrderBuild {


    public static OrderData setUpOrder(String cartId, String customerName) {
        OrderData createOrderData = OrderData.builder().build();
        createOrderData.setCartId(cartId);
        createOrderData.setCustomerName(customerName);
        return createOrderData;
    }


}
