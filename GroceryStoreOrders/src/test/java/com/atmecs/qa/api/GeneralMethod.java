package com.atmecs.qa.api;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GeneralMethod {
    public static Logger logger = Logger.getLogger(GeneralMethod.class);

    public static Response getApi(String url) {
        try {
            return given()
                    .contentType(ContentType.JSON)
                    .log().all()
                    .when()
                    .get(url);
        } catch (Exception exception) {
            logger.error("get api is not performed" + exception);
        }
        return null;
    }

    public static Response postApi(String token, Object body, String url) {
        try {
            return given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + token)
                    .body(body)
                    .log().all()
                    .when()
                    .post(url);
        } catch (Exception exception) {
            logger.error("Post api is not performed" + exception);
        }
        return null;
    }

    public static Response patchApi(String token, Object body, String url, Map<String, String> pathParam) {
        try {
            return given()
                    .relaxedHTTPSValidation()
                    .contentType(ContentType.JSON)
                    .pathParams(pathParam)
                    .header("Authorization", "Bearer " + token)
                    .body(body)
                    .log().all()
                    .when()
                    .patch(url);

        } catch (Exception exception) {
            logger.error("Patch api is not performed" + exception);
        }
        return null;
    }

    public static Response deleteApi(String token, String url, Map<String, String> pathParam) {
        try {
            return given()
                    .contentType(ContentType.JSON)
                    .pathParams(pathParam)
                    .header("Authorization", "Bearer " + token)
                    .log().all()
                    .when()
                    .delete(url);
        } catch (Exception exception) {
            logger.error("Delete API is not performed" + exception);
        }
        return null;
    }


    public static Response postApiWithPathParams(Object body, String url, Map<String, String> pathParams) {
        try {
            return given()
                    .contentType(ContentType.JSON)
                    .pathParams(pathParams)
                    .body(body)
                    .log().all()
                    .when()
                    .post(url);
        } catch (Exception exception) {
            logger.error("Post API with path params is not performed" + exception);
        }
        return null;
    }

    public static Response postApiWithoutBody(String url) {
        try {
            return given()
                    .contentType(ContentType.JSON)
                    .log().all()
                    .when()
                    .post(url);
        } catch (Exception exception) {
            logger.error("post Api Without Body is not performed" + exception);
        }
        return null;
    }


    public static void validateSchema(Response response, String path) {
        try {
            response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(path));
        } catch (Exception exception) {
            logger.info("Validate scheme is not performed" + exception);
        }
    }
    public static Response getAuthApi(String token,String url) {
        try {
            return given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + token)
                    .log().all()
                    .when()
                    .get(url);
        } catch (Exception exception) {
            logger.error("get api is not performed" + exception);
        }
        return null;
    }

}

