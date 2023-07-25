package test;

import constant.Constant;
import org.testng.annotations.Test;

@Test
public class AllMethods {
    // Generated methods based on keys
    public static String TypeOfOrganization() {
        // System.out.println("organizationType()");
        String value = "Then ";
        return ("I provide field 'Organization Type' with value '[#]OrgType'\n" +
                value + "I provide field 'Int Organization Sub Type' with value '[#]InternalSubOrgType'\n" +
                value + "I provide field 'Vendor ID' with value '[#]OrgNum'\n" +
                value + "I invoke operation 'Save'\n");
    }

    public static String ClickEditIcon() {
        // System.out.println("contextmenu()");
        // Add your test logic here
        return (" I prepare item screen 'Base Org Header' for the entity 'Organization' in mode 'Add'\n" +
                "\n");
    }

    public static String CreateOrganization() {
        // System.out.println("createNewOrganization()");
        // Add your test logic here
        String a = "Then ";
        return ("I prepare list screen 'Organization List' with given mode 'Normal' \n" +
                a + "I remove all search filters\n" +
                a + "I add search filters perform search and store result in a variable '_ParentInstanceId'");
    }

    public static String Login() {
        // System.out.println("login()");
        // Add your test logic here
        return "I login as " + Constant.username + " and " + Constant.password;
    }

    public static String Verification() {
        // System.out.println("verification()");
        // Add your test logic here
        String a = "Then ";
        return ("I provide field 'Organization Type' with value '[#]OrgType'\n" +
                a + "I provide field 'Int Organization Sub Type' with value '[#]InternalSubOrgType'\n" +
                a + "I provide field 'Vendor ID' with value '[#]OrgNum'\n" +
                a + "I invoke operation 'Save'\n");
    }

}
