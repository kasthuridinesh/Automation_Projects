package com.atmecs.qa.pojo.widgeDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class Text {
    private String data;
    private Integer size;
    private String alignment;
    private String onmouseup;

}
