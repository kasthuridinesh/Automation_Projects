package com.atmecs.qa.generalMethods;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherApi {

	
	// Logger logger = Logger.getLogger(WeatherApi.class);
	@Test
	public void postCallWeatherQueryParams() {

		String apiKey = readProperty("apikey");
		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/weather";
		Response response = given().contentType(ContentType.JSON).queryParam("appid", apiKey).queryParam("lat", "44.34")
				.queryParam("lon", "10.99").when().post();

		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
	}

	@Test
	public void postCallWeather() {

		String apiKey = readProperty("apikey");
		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/weather";
		Response response = given().contentType(ContentType.JSON).queryParam("appid", apiKey)
				.queryParam("q", "Delhi", "India").when().post();

		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
	}

	@Test
	public void postCallWeatherMulti() {

		String apiKey = readProperty("apikey");
		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/weather";

		List<String> categoryValues = Arrays.asList("Delhi", "IN");
		Response response = given().spec(withMultiValueParameters(RestAssured.given().log().all(), "q", categoryValues))
				.queryParam("appid", apiKey).when().post();

		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
	}
	
	
	

	/**
	 * 
	 * Methode Description : Read Value From property File
	 * 
	 * parameter : resource key in property file.
	 * Author : Arivarasan A .
	 * 
	 */
	
	public String readProperty(String resourcekey) {

		String value = null;
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;

		try {
			// Load the property file
			String userDir = System.getProperty("user.dir") + File.separator + "config.properties";
			fileInputStream = new FileInputStream(userDir);
			properties.load(fileInputStream);
			
			// Get values from the property file
			value = properties.getProperty(resourcekey);
			
			
			return value;
         
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Close the input stream
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	public static RequestSpecification withMultiValueParameters(RequestSpecification requestSpec, String parameterName,
			List<String> parameterValues) {
		
		try {
		//	for (String value : parameterValues) {
				requestSpec.queryParam(parameterName, parameterValues.toString().replaceAll("[^a-zA-Z0-9,]", ""));
		//	}
			return requestSpec;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
