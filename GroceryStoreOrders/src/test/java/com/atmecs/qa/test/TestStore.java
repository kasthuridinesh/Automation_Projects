package com.atmecs.qa.test;

import org.testng.annotations.Test;

public class TestStore {
    TestOrders orders = new TestOrders();
    @Test
    public void createOrder(){
        orders.createNewCart();
        orders.getAllProductID();
        orders.addItemToCartId();
        orders.createNewOrder();


    }
    @Test
    public void updateOrder(){
        orders.createNewCart();
        orders.getAllProductID();
        orders.addItemToCartId();
        orders.createNewOrder();
        orders.updateOrder();


    }
    @Test
    public void getOrder(){
        orders.createNewCart();
        orders.getAllProductID();
        orders.addItemToCartId();
        orders.createNewOrder();
        orders.updateOrder();
        orders.getOrder();
    }
    @Test
    public void deleteOrder(){
        orders.createNewCart();
        orders.getAllProductID();
        orders.addItemToCartId();
        orders.createNewOrder();
        orders.updateOrder();
        orders.getOrder();
    }


}
