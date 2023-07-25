package qa.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HttpMethods {
    @Test
    public void getMethod() {
        Response resp = null;
        resp = RestAssured.given().get("https://reqres.in/api/users?page=2");
        System.out.println("printing entire data " + resp.asPrettyString());
        System.out.println("printing status code " + resp.statusCode());
        System.out.println("printing Content type " + resp.contentType());
        System.out.println("printing session id " + resp.sessionId());


    }
    @Test
    public void deleteMethod(){
        Response response = RestAssured.given().delete("https://reqres.in/api/users/2");
        System.out.println("Status code after deleting:"+response.statusCode());
        System.out.println(response.asPrettyString());

    }


}
