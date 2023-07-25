package com.api.automation.runner;

import com.api.automation.utils.ApiUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import static com.api.automation.constant.Constant.CART_ID;
import static com.api.automation.constant.Constant.CART_RESPONSE_ID;
import static com.api.automation.utils.UrlConstant.CREATE_CART_URL;


public class TestRunner {

    @Test
    public void createAnCart(String responseCode) {
        Response createCart = null;
        try {
            createCart = ApiUtils.postApiWithoutBody(CREATE_CART_URL);
         //   logger.info( createCart.prettyPeek());
            JsonPath jsonPathEvaluator = createCart.jsonPath();
            CART_ID = jsonPathEvaluator.get(CART_RESPONSE_ID);
            Assert.assertEquals( Integer.parseInt(responseCode), createCart.getStatusCode());
           // ApiUtils.validateSchema(createCart, "createCart.json");
        } catch (Exception exception) {
         //   logger.error(ErrorMessages.EXCEPTION_OCCUR + exception.getMessage());
        }
    }}


