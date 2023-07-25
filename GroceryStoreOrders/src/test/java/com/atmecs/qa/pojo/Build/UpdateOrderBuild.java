package com.atmecs.qa.pojo.Build;

import com.atmecs.qa.pojo.dto.UpdateOrderData;

public class UpdateOrderBuild {
    public static UpdateOrderData setUpdateOrder(String patchCustomerName) {
        UpdateOrderData updateOrderData = UpdateOrderData.builder().build();
        updateOrderData.setPatchCustomerName(patchCustomerName);
        return updateOrderData;
    }
}
