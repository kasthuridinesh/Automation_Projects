package com.atmecs.qa.test;
// ******************* Importing Libraries ***********************

import com.atmecs.qa.api.GeneralMethod;
import com.atmecs.qa.utils.Endpoints;
import com.atmecs.qa.utils.StatusCode;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.atmecs.qa.pojo.Build.CreateProductIdJson.setUpProductId;
import static com.atmecs.qa.pojo.Build.OrderBuild.setUpOrder;
import static com.atmecs.qa.pojo.Build.UpdateOrderBuild.setUpdateOrder;
import static com.atmecs.qa.utils.Constant.*;
import static com.atmecs.qa.utils.Endpoints.*;

/*
Author : kasthuri
 */
public class TestOrders {
    public static Logger logger = Logger.getLogger(TestOrders.class);

    //  Create new order to fetch  cart id
    @Test(groups = {"endtoend", "post"}, priority = 1)
    public void createNewCart() {
        Response createCart = null;
        try {
            createCart = GeneralMethod.postApiWithoutBody(createCartEndPoint);
            assert createCart != null;
            logger.info(createCart.prettyPeek());
            JsonPath jsonPathEvaluator = createCart.jsonPath();
            CART_ID = jsonPathEvaluator.get(CART_RESPONSE_ID);
            Assert.assertEquals(StatusCode.CREATE.getStatusCode(), createCart.getStatusCode());
            GeneralMethod.validateSchema(createCart, "createCart.json");
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        } finally {
            {
                logger.error("Server error");


            }
        }
    }

    // Method used to get all product details to fetch product id
    @Test(groups = {"endtoend", "getallproduct"}, priority = 2)
    public void getAllProductID() {
        Response getProduct = null;
        try {
            getProduct = GeneralMethod.getApi(GET_PRODUCT_URL);
            assert getProduct != null;
            logger.info(getProduct.prettyPeek());
            JsonPath jsonPathEvaluator = getProduct.jsonPath();
            PRODUCT_ID = jsonPathEvaluator.getString(PRODUCT_RESPONSE_ID);
            Assert.assertEquals(StatusCode.OK.getStatusCode(), getProduct.getStatusCode());
            GeneralMethod.validateSchema(getProduct, "getProduct.json");
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        } finally {

            logger.error("Server Error");
        }
    }

    // Method used to add item to cart for fetching item id by passing product id and cart id
    @Test(groups = {"endtoend", "ItemToCart"}, priority = 3)
    public void addItemToCartId() {
        try {

            HashMap<String, String> pathParams = new HashMap<>();
            pathParams.put("productId", CART_ID);
            Response addItem = GeneralMethod.postApiWithPathParams(setUpProductId(ID), ADD_ITEM_URL, pathParams);
            assert addItem != null;
            logger.info(addItem.prettyPeek());
            JsonPath jsonPathEvaluator = addItem.jsonPath();
            ITEM_ID = jsonPathEvaluator.getString(ITEM_RESPONSE_ID);
            Assert.assertEquals(StatusCode.CREATE.getStatusCode(), addItem.getStatusCode());
            GeneralMethod.validateSchema(addItem, "addProductItem.json");
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        } finally {
            logger.error("Server Error");
        }

    }
    //*************************************************************************************************************

    // Method used to create new order by passing cartid and get order id
    @Test(groups = {"endtoend", "CreateOrder"}, priority = 4)
    public void createNewOrder() {
        Response createOrderData = null;
        try {
            createOrderData = GeneralMethod.postApi(BEARER_TOKEN, setUpOrder(CART_ID, CustomerCreateName), POST_ORDER_URL);
            assert createOrderData != null;
            logger.info(createOrderData.asPrettyString());
            JsonPath jsonPathEvaluator = createOrderData.jsonPath();
            ORDER_ID = jsonPathEvaluator.get("orderId");
            Assert.assertEquals(StatusCode.CREATE.getStatusCode(), createOrderData.getStatusCode());
            GeneralMethod.validateSchema(createOrderData, "createOrder.json");

        } catch (Exception exception) {
            logger.error(exception.getMessage());

        } finally {

            logger.error("Server Error");
        }
    }

//    public void createNewOrder() {
//    Response createOrderData = null;
//    try {
//        // Modify the request payload or URL to trigger a bad request scenario
//        createOrderData = GeneralMethod.postApi(BEARER_TOKEN, setUpOrder(CART_ID, CustomerCreateName), POST_ORDER_URL);
//        assert createOrderData != null;
//        logger.info(createOrderData.asPrettyString());
//        Assert.assertEquals(StatusCode.BADREQUEST.getStatusCode(), createOrderData.getStatusCode());
//        GeneralMethod.validateSchema(createOrderData, "createOrder.json");
//
//    } catch (Exception exception) {
//        logger.error(exception.getMessage());
//    } finally {
//        logger.error("Server Error");
//    }
//}


//In the modified code, the setUpInvalidOrder() method is used to set up an invalid order payload that triggers a bad request. You can define the method to generate an invalid order payload based on your test requirements. By expecting a status code of StatusCode.BAD_REQUEST.getStatusCode(), which should be set to 400, the assertion will pass if the response contains a 400 status code.


    // Method used to update already crated order
    @Test(groups = {"endtoend", "updateOrder"}, priority = 5)
    public void updateOrder() {
        Response updateOrder = null;
        try {
            HashMap<String, String> pathParams = new HashMap<>();
            pathParams.put("orderId", ORDER_ID);
            updateOrder = GeneralMethod.patchApi(BEARER_TOKEN, setUpdateOrder(CustomerNameUpdate), UPDATE_ORDER_URL, pathParams);
            assert updateOrder != null;
            logger.info(updateOrder.prettyPeek());
            Assert.assertEquals(StatusCode.NOCONTENT.getStatusCode(), updateOrder.getStatusCode());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        } finally {
            logger.error("Server error");
        }
    }

    // method used to getOrders
    @Test(groups = {"endtoend", "deleteOrder"}, priority = 6)

    public void getOrder() {
        Response getOrder = null;
        try {
            getOrder = GeneralMethod.getAuthApi(BEARER_TOKEN, GET_ORDER_URL);
            assert getOrder != null;
            logger.info(getOrder.prettyPeek());
            Assert.assertEquals(StatusCode.OK.getStatusCode(), getOrder.getStatusCode());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        } finally {
            logger.error("Server error");
        }
    }
// Method used to delete

    @Test(groups = {"endtoend", "deleteOrder"}, priority = 7)
    public void deleteOrder() {
        Response deleteOrder = null;
        try {
            HashMap<String, String> pathParams = new HashMap<>();
            pathParams.put("orderId", ORDER_ID);
            deleteOrder = GeneralMethod.deleteApi(BEARER_TOKEN, DELETE_ORDER_URL, pathParams);
            assert deleteOrder != null;
            logger.info(deleteOrder.prettyPeek());
            Assert.assertEquals(StatusCode.NOCONTENT.getStatusCode(), deleteOrder.getStatusCode());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        } finally {
            logger.error("Server Error");
        }

    }
}
