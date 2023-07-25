package qa.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Reqres {
    @Test
    public void getMethod() {
        Response resp = null;   // https://reqres.in/api/users/2
        resp = RestAssured.given().get("https://reqres.in/api/users?page=2");
        System.out.println("printing entire data " + resp.asPrettyString());
        System.out.println("printing status code " + resp.statusCode());
        System.out.println("printing Content type " + resp.contentType());
        System.out.println("printing session id " + resp.sessionId());
    }

    @Test
    public void getById() {
        given()
                .baseUri("https://reqres.in")
                .pathParam("id", 2)
                .when()
                .get("/api/users/{id}")
                .then()
                .statusCode(200)
                .log().all();


    }
}

