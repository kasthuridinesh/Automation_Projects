package org.action_class;

import org.testng.annotations.Test;
import org.utils.JsonReader;

public class UnitTesting {
    @Test
    public void unitRunner(){
        ActionClass object = new ActionClass();
        object.loginToApplication(JsonReader.getJson("userName"), JsonReader.getJson("password"));
    }
}
