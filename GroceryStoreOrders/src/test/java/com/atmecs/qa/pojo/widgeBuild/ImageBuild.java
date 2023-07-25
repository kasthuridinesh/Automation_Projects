package com.atmecs.qa.pojo.widgeBuild;

import com.atmecs.qa.pojo.widgeDto.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.awt.*;

import static java.awt.Image.*;


public class ImageBuild {

    @Test
    public void payload() throws JsonProcessingException {


        Text buildText = Text.builder().data("Click Here").size(23).alignment("center").onmouseup("sun1.opacity = (sun1.opacity / 100) * 90;\"").build();
        Images buildImage = Images.builder().src("Images/Sun.png").voffset(250).alignment("center").build();
        Windows buildsWindows = Windows.builder().title("Sample Konfabulator Widget").height(500).width(500).build();
        Widge buildWidgets = Widge.builder().debug("on").text(buildText).window(buildsWindows).image(buildImage).build();

        RootKasthuri buildRoot = RootKasthuri.builder().widget(buildWidgets).build();
        ObjectMapper mapper = new ObjectMapper();
        String requestbody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(buildRoot);

        System.out.println(requestbody);


    }

}
