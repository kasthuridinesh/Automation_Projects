package com.atmecs.qa.pojo.Build;

import com.atmecs.qa.pojo.dto.CreateProductId;

public class CreateProductIdJson {
    public static Object setUpProductId(String productId) {
        CreateProductId createProductId = new CreateProductId();
        createProductId.setProductId(productId);
        return createProductId;
}}
