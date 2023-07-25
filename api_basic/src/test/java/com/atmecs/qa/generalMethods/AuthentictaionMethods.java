package com.atmecs.qa.generalMethods;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.qa.dto.Statuscode;



public class AuthentictaionMethods extends Baseclass{

	Baseclass base=new Baseclass();

	 Logger logger = Logger.getLogger(AuthentictaionMethods.class);

	@Test
	public Response getcall(String getUrl,String paramerKey,String paramerValue) {
		Response response=null;
		try {

			RequestSpecification requestSpec = base.noAuth().log().all();
			RequestSpecification getPathParameter = base.pathParameter(requestSpec, paramerKey, paramerValue);
			response = getPathParameter.when().get(getUrl);//.replace(paramerKey, paramerValue));
			
			logger.info("Sucessfuly data retrive");
			
			return response;

		} catch (Exception e) {
			logger.info("Failed to retrived data");
		}
		return null;
	}
	
	
	public Response postCall(String getUrl,String bodyValue) {
		Response postResponse=null;
		try {

			RequestSpecification requestspec = base.noAuth().contentType(ContentType.JSON);
			RequestSpecification getRequestBody = base.requestBody(requestspec, bodyValue);
						
			 postResponse = getRequestBody.when().post(getUrl);

			logger.info("sucessfuly data retrived+"+postResponse.getStatusCode());
			return postResponse;

		} catch (Exception e) {
			logger.info("Failed to retrived data");
		}
		return null;
	}
	public Response putCall(String getUrl,String bodyValue,String resource) {
		Response putResponse=null;
		try {

			RequestSpecification requestspec = base.noAuth().contentType(ContentType.JSON).log().all();
			RequestSpecification getRequestBody = base.requestBody(requestspec, bodyValue);
						
			 putResponse = getRequestBody.when().put(getUrl+resource);

			logger.info("sucessfuly data retrived+"+putResponse.getStatusCode());
			return putResponse;

		} catch (Exception e) {
			logger.info("Failed to retrived data");
		}
		return null;
	}
	public Response deleteCall(String Url,String paramerKey,String paramerValue) {
		Response response=null;
		try {

			RequestSpecification requestSpec = base.noAuth().log().all();
			//RequestSpecification getPathParameter = base.pathParameter(requestSpec, paramerKey, paramerKey);
			response = requestSpec.when().delete(Url.replace(paramerKey, paramerValue));
			
			logger.info("Sucessfuly data retrived"+Url);
			System.out.println("Sucessfuly data retrived"+Url.replace(paramerKey, paramerValue));
			return response;

		} catch (Exception e) {
			logger.info("Failed to retrived data");
		}
		return null;
	}
	













































	@BeforeTest
	public void log4jConfig() {

		try {
			PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "logs" + File.separator + "log4j.properties");

			logger.info("logger initilazed succesfully");
		} catch (Exception e) {
			logger.error("log4j configuration file is missing"+e);
		}
	}


	/*
	 * Methode description : Generate Basic Authentication
	 * 
	 *  Parameters baseurl,username,passowrd
	 *  
	 *  Author: Arivarasan A
	 * */
	public void basicAuth(String baseuri, String username, String password) {
		try {
			given().auth().basic(username, password)
			.when().get(baseuri)
			.then().assertThat().statusCode(Statuscode.ok.getCode());
			logger.info("Response gathered from server for the  BASIC Authentication");

		} catch (Exception e) {

			logger.error("exception in Bascic Auth :" + e);
		}

	}

	public void apiKeyauth(String Baseuri, String apiKeyvalue) {
		/// youtube data api
		try {
			given()
			.when().get(Baseuri.replace("YOUR_API_KEY", apiKeyvalue))
			.then().assertThat().statusCode(200);

			System.out.println("Response gathered from server for the APIKEY Authentication");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print("exception in Apikey Auth :" + e);
		}

	}

	public void bearerTokenauth(String Baseuri, String bearerTokenvalue) {
		/// git hub

		try {
			// given().header("Authorization", "Bearer " + bearerTokenvalue)
			// .when().get(Baseuri).prettyPrint();

			given().header("Authorization", "Bearer " + bearerTokenvalue)
			.when().get(Baseuri)
			.then().assertThat().statusCode(200);

			System.out.println("Response gathered from server for the bearerToken Authentication");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print("exception in BearerToken Auth :" + e);
		}

	}


	public  String getAuthorizationCode() {

		String AuthendPoint="https://accounts.google.com/o/oauth2/auth";
		String clientID="392601246463-m6q4k8u1s9k562jlp59k423nps91mh2p.apps.googleusercontent.com";
		String redirectUrl="https://oauth.pstmn.io/v1/callback";
		String emailID="arivarasan.arivudainambi@atmecs.com";

		// Build the authorization URL
		String authorizationUrl = AuthendPoint + "?response_type=code"
				+ "&client_id=" + clientID
				+ "&redirect_uri=" + redirectUrl
				+ "&scope=https://mail.google.com/"
				+"&login_hint="+emailID;

		System.out.println("Please authorize the application by visiting the following URL:");
		System.out.println(authorizationUrl);
		// System.out.println("Enter the authorization code:");

		//	        Response response = given().redirects().follow(false).get(authorizationUrl);
		//	        String redirectUrl = response.getHeader("Location");
		//	        
		//	        System.out.println(redirectUrl+"wedqsd");


		//	        CloseableHttpClient client = HttpClients.createDefault();
		//	        HttpGet request = new HttpGet(authorizationUrl);
		//
		//	        HttpResponse response = null;
		//			try {
		//				response = client.execute(request);
		//			} catch (IOException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}
		//	        Header[] headers = response.getHeaders("Location");
		//	        System.out.println(headers+"wehdqwukdbqwkdbqw");
		//	        String redirectUrl1 = headers[0].getValue();
		//	        
		//	        System.out.println(redirectUrl1+"qwdqwdqw");










		//	        Response authResponse = given()
		//	        	    .get(redirectUrl);
		//	        String authorizationCode = authResponse.getBody().asString();;
		//	        System.out.println(authorizationCode+"gfxgfxhgcgh");



		//   String authorizationCode = extractAuthorizationCode(redirectUrl1);
		//     Read the authorization code from the user
		Scanner scanner = new Scanner(System.in);
		String authorizationCode = scanner.nextLine();
		scanner.close();
		System.out.println(authorizationCode);
		///return authorizationCode
		//System.out.println(authorizationCode+"rwef");
		return authorizationCode;
		//return null;
	}


	public String getAcessToken() {
		String access_tokenName=null;
		try {

			String accesstokenURL = "https://accounts.google.com/o/oauth2/token";
			String clientId = "392601246463-m6q4k8u1s9k562jlp59k423nps91mh2p.apps.googleusercontent.com";
			String clientSecret = "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";
			String grantType = "authorization_code";
			String authorizationCode="4%2F0AbUR2VMnJpbmIdkyLyHy7BIL4nEzB20UFIZJaTTFq0t0EwYO7IqGHLeRQjWgAym0gbeUeQ";getAuthorizationCode();
			String scope = "https://mail.google.com/";
			String callBackUrl="https://oauth.pstmn.io/v1/callback";

			Response response =given()
					.auth().preemptive()// CHECK THE AUTH INFO
					.basic(clientId,clientSecret)
					.param("grant_type",grantType)
					.param("code", authorizationCode)
					.param("scope", scope)
					.param("redirect_uri", callBackUrl)
					.log().all()
					.post(accesstokenURL);
			response.prettyPrint();
			System.out.println("status code is" +response.statusCode());
			access_tokenName=response.getBody().path("access_token");
			System.out.println("Access token is" +access_tokenName);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return access_tokenName;


	}




	public void Oauth2auth(String baseUrl) {
		// github
		try {



			String oauthBeartokenkey=getAcessToken();

			//String oauthBeartokenkey="ya29.a0AWY7Ckkck3_RldJDo9lh4fwCxgysA2A5TOjkT9XPthye7V1yaoTjZFzQh22aaPAnHW3Z0i7nBCl1zRUcKpK813dYmioQWh_Cff7pLbPAW1jlwgWwuIFV7PQuZQlyuqhQfiKLjUD9CO91tHuYD--yxb9YlinEBAaCgYKAVYSARMSFQG1tDrpDwnzZhFBdWW5OrTYNTmVGA0165";
			System.out.println(oauthBeartokenkey+"=efdwe");

			given().auth().oauth2(oauthBeartokenkey)
			.contentType("application/json")
			.when().get(baseUrl)
			.then().assertThat().statusCode(200);

			given().auth().oauth2(oauthBeartokenkey)
			.contentType("application/json")
			.when().get(baseUrl).prettyPrint();

			System.out.println("Response gathered from server for the OauthBearerToken Authentication");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print("exception in OauthBearerToken Auth :" + e);
		}
	}

	public void Oauth2authPost(String baseUrl) {
		// github
		try {

			String payload="{\r\n"
					+ "  \"message\": {\r\n"
					+ "    \"raw\": \"VGhpcyBpcyBhIHRlc3QgZnJvbSBhIGRyYWZ0IG1lc3NhZ2Uu\"\r\n"
					+ "  }\r\n"
					+ "}";

			//String oauthBeartokenkey=getAcessToken();

			String oauthBeartokenkey="ya29.a0AWY7CkmTvdpLKZtPw5v-wYXUWNECyR4SKHLjj8UO8mGiziQWNisaZ8VbzedYIOV0kzE4A800tYKlPmP-0hksnzPAeaUo4KS0VFglGeLDRvdACVo4OfMOX4k3gZfcxfmnRd9qASw7pqh7taokHxdfO17V5ahJKQaCgYKATsSARMSFQG1tDrpVeQoXL4U0gYkLpZQMWKqFA0165";
			System.out.println(oauthBeartokenkey+"=efdwe");

			given().auth().oauth2(oauthBeartokenkey)
			.contentType("application/json")
			.body(payload)
			.when().post(baseUrl)
			.then().assertThat().statusCode(200);

			given().auth().oauth2(oauthBeartokenkey)
			.contentType("application/json")
			.when().post(baseUrl).prettyPrint();

			System.out.println("Response gathered from server for the OauthBearerToken Authentication");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print("exception in OauthBearerToken Auth :" + e);
		}
	}


	public String extractAuthorizationCode(String redirectUrl) {
		// Extract the value of the "code" parameter from the redirect URL
		// Example implementation using regular expressions:
		Pattern pattern = Pattern.compile("code=(.*?)(&|$)");
		Matcher matcher = pattern.matcher(redirectUrl);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null; // Handle the case where the authorization code is not found
	}




}
