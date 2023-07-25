package com.atmecs.qa.pojo.widgeDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder

@Getter
public class Windows {
    private String title;
    private Integer width;
    private Integer height;

}
