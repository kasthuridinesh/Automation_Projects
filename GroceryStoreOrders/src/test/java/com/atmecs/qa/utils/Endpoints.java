package com.atmecs.qa.utils;

public class Endpoints {
    FileReader filereader = new FileReader();

    public String BaseURL() {
        return filereader.getAttribute("BaseURI");

    }

    public static String createCartEndPoint = "https://simple-grocery-store-api.glitch.me/carts";
    public static final String BASE_URL_ORDER = "https://simple-grocery-store-api.glitch.me";
    public static final String POST_ORDER_URL = BASE_URL_ORDER + "/orders";
    public static final String GET_CREATED_ORDER_URL = POST_ORDER_URL + "/{orderId}";
    public static final String UPDATE_ORDER_URL = GET_CREATED_ORDER_URL;
    public static final String DELETE_ORDER_URL = GET_CREATED_ORDER_URL;
    public static final String CREATE_CART_URL = BASE_URL_ORDER + "/carts";
    public static final String GET_PRODUCT_URL = BASE_URL_ORDER + "/products";
    public static final String ADD_ITEM_URL = CREATE_CART_URL + "/{productId}/items";
    public static final String GET_ORDER_URL =BASE_URL_ORDER+"/orders";
}
