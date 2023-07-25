package com.atmecs.qa.generalMethods;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.atmecs.qa.dto.Statuscode;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class herokucookies extends Baseclass{

	Logger logger=Logger.getLogger(herokucookies.class);
	
	herokucookies heroku= new herokucookies();
	
	
	public void herokumultipartpost() {

		try {

			File path=new File(System.getProperty("user.dir")+File.separator+"src"
					+File.separator+"test"+File.separator+"resources"+File.separator+"sample.avif");

			given().multiPart(path).contentType(ContentType.MULTIPART).when()
			.post("https://the-internet.herokuapp.com/upload")
			.then().statusCode(Statuscode.ok.getCode()).log().all();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public static String zomatocsrf() {
		// Set cookies
		String csrfToken=null;
		try {
		
			baseURI = "https://www.zomato.com/webroutes";
			Response response = given()
					.when()
					.get ("/auth/csrf");
//					.then()
//					.statusCode(Statuscode.ok.getCode())
//					.extract().response();
			//response.getBody().pat)
			System.out.println("wedqwd "+response.asPrettyString());

			//Map<String, String> cookies = response.getCookies();
			 //csrfToken = cookies.get("__csrf_token");


		//	logger.info(csrfToken);
			return csrfToken;
		} catch (Exception e) {
			
			System.out.println("expec");

		//	logger.error("failed on generation of csrf token"+e);
		}
		return null;

	}

	@Test
	public void zomatopostcall() {
		// Set cookies
		try {

			JSONObject readJsonvalue = heroku.readJsonFile(System.getProperty("user.dir")+File.separator+"payload.json");

			
			
			System.out.println(readJsonvalue);
			baseURI="https://jumbo.zomato.com/event";

			ValidatableResponse all = given().accept(ContentType.JSON)
					.cookie("csrf_token", "6bc9b537d98961444b5cb9971cae85cc")
					.queryParam("user_id", "301302214")
					.body(readJsonvalue)
					.when()
					.post()
					.then().statusCode(Statuscode.ok.getCode()).log().all();

			logger.info(all);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String csrf = response.getBody().toString();
	}
	
	
	public static void main(String[] args) {
		
		herokucookies.zomatocsrf();
		
	}
}


