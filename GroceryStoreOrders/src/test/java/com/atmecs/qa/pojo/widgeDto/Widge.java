package com.atmecs.qa.pojo.widgeDto;

import lombok.Builder;
import lombok.Getter;

import java.awt.*;

@Builder
@Getter
public class Widge {
    private String debug;
    private Windows window;
    private Images image;
    private Text text;


}
