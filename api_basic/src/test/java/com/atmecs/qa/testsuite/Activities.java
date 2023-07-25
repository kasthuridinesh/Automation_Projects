package com.atmecs.qa.testsuite;

import java.io.File;
import java.io.PrintStream;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.atmecs.qa.dto.ActivitiesDTO;
import com.atmecs.qa.dto.Statuscode;
import com.atmecs.qa.generalMethods.AuthentictaionMethods;
import com.atmecs.qa.generalMethods.Baseclass;
import com.atmecs.qa.utilities.Endpoints;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;

public class Activities {
	 Logger logger = Logger.getLogger(Activities.class);
	 AuthentictaionMethods activityMethodes = new AuthentictaionMethods();
	 
	 Baseclass base =new Baseclass();
	 
	 
	@Test
	public  void activityMethods() {
		
		try {
			
			String activityID = base.retrieveData("TC01","Activity","id");
			String activityTitle = base.retrieveData("TC01","Activity","title");
			String activityStatus = base.retrieveData("TC01","Activity","completed");
			String activityStatusUpdated = base.retrieveData("TC02","Activity","completed");
			
			String filepath=System.getProperty("user.dir") + File.separator + "data"
   			     +File.separator+"ActivitySchema.json";;
   			     
   			 
   			// logger configuration.
   			PrintStream fileOutPutStream = new PrintStream(new File("./somefile.txt"));
   			RestAssured.config =RestAssured.config().logConfig(new LogConfig().defaultStream(fileOutPutStream)); 
			

			String payLoad = ActivitiesDTO.payloadActives(Integer.parseInt(activityID),activityTitle, activityMethodes.localeDate(),true);
			String modifiedPayLoad = ActivitiesDTO.payloadActives(Integer.parseInt(activityID),activityTitle, activityMethodes.localeDate(),false);

						
			// Activity creation.
			
			Response activityCreated = activityMethodes.postCall(Endpoints.fakeApiPostUrl, payLoad);
			logger.info("Activity created response body"+activityCreated.then().assertThat().statusCode(Statuscode.ok.getCode()));
			logger.info("Activity created response body"+activityCreated.then().log().body().toString());
			activityMethodes.schemaValidation(activityCreated,filepath);
			// storing activity id for chain call
			String activityId = activityMethodes.reaponsePropertyReader(activityCreated, "id");

			// Activity retrevive details after creation
			Response getActivityResponse = activityMethodes.getcall(Endpoints.fakeApiGeturl, "activityID",activityId);
			logger.info("Activity Retrived response"+ getActivityResponse.then().assertThat().statusCode(Statuscode.ok.getCode()));
			logger.info("Activity Retrived response body"+getActivityResponse.getBody().asPrettyString());
			activityMethodes.schemaValidation(getActivityResponse,filepath);
			
			// Activity updation of data
			Response activityModify = activityMethodes.putCall(Endpoints.fakeApiPutUrl, modifiedPayLoad, activityId);
			logger.info("Activity updation response body"+ activityModify.then().assertThat().statusCode(Statuscode.ok.getCode()));
			logger.info("Activity updation response body"+activityModify.getBody().asPrettyString());
			activityMethodes.schemaValidation(activityModify,filepath);
			// Deleting the Activity Record
			Response deleteActivityResponse = activityMethodes.deleteCall(Endpoints.fakeApiGeturl, "activityID",activityId);
			logger.info("Activity Delete response body"+ deleteActivityResponse.then().assertThat().statusCode(Statuscode.ok.getCode()));
			logger.info("Activity Delete response body"+ deleteActivityResponse.getBody().asPrettyString());
			
		} catch (Exception e) {
			
			logger.error("failed to do the Activity methode in fakeRestApi");
		}
		finally {
//			if (response.getStatusCode() >= 500) {
//                // Handle the 500 series error
//                System.out.println("Server error occurred: " + response.getStatusCode());
//            } else {
//                // Process the response for successful requests
//                System.out.println("Request succeeded: " + response.getStatusCode());
//            }
			logger.info("Executing finally block");
		}
	}

}
