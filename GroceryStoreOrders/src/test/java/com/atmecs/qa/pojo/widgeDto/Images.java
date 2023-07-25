package com.atmecs.qa.pojo.widgeDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class Images {
    private String src;
    private Integer voffset;
    private String alignment;

}
