package com.atmecs.qa.test;

import com.atmecs.qa.api.GeneralMethod;
import com.atmecs.qa.utils.StatusCode;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.atmecs.qa.pojo.Build.OrderBuild.setUpOrder;
import static com.atmecs.qa.pojo.Build.UpdateOrderBuild.setUpdateOrder;
import static com.atmecs.qa.utils.Constant.*;
import static com.atmecs.qa.utils.Endpoints.POST_ORDER_URL;
import static com.atmecs.qa.utils.Endpoints.UPDATE_ORDER_URL;


public class TestRunner {
    public static Logger logger = Logger.getLogger(TestOrders.class);
    @Test
    public void createNewOrder() {

        Response createOrderData = null;
        try {
            // Modify the request payload or URL to trigger a bad request scenario
            createOrderData = GeneralMethod.postApi(BEARER_TOKEN, setUpOrder("null", CustomerCreateName), POST_ORDER_URL);
            assert createOrderData != null;
            logger.info(createOrderData.asPrettyString());
            logger.info(createOrderData.statusCode());
            Assert.assertEquals(StatusCode.BADREQUEST.getStatusCode(), createOrderData.getStatusCode());
//            GeneralMethod.validateSchema(createOrderData, "createOrder.json");

        } catch (Exception exception) {
            logger.error(exception.getMessage());
        } finally {
            logger.error("Server Error");
        }

    }
    @Test(groups = {"endtoend", "updateOrder"}, priority = 5)
    public void updateOrder() {
        Response updateOrder = null;
        try {
            HashMap<String, String> pathParams = new HashMap<>();
            pathParams.put("orderId", String.valueOf(ORDER_ID));
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



}
