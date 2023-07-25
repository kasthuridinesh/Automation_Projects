package com.atmecs.qa.pojo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderData {
    private String cartId;
    private String customerName;

}
