package com.atmecs.qa.generalMethods;

import java.util.Scanner;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class modularization {
	
	
	 public static String getAuthorizationCode() {
		 
		 String Authendpoint="https://accounts.google.com/o/oauth2/auth";
		 String clientID="392601246463-m6q4k8u1s9k562jlp59k423nps91mh2p.apps.googleusercontent.com";
		 String redirecturl="http://localhost:9999/Callback";//"https://oauth.pstmn.io/v1/callback";
		 String emailId="arivarasan.arivudainambi@atmecs.com";
		 
	        // Build the authorization URL
	        String authorizationUrl = Authendpoint + "?response_type=code"
	                + "&client_id=" + clientID
	                + "&redirect_uri=" + redirecturl
	                + "&scope=https://mail.google.com/"
	                + "&login_hint=" + emailId;

	        System.out.println("Please authorize the application by visiting the following URL:");
	        System.out.println(authorizationUrl);
	        System.out.println("Enter the authorization code:");
	        
	       
	        
	        
	        
	        Response response = RestAssured.given().redirects().follow(false).when().get(authorizationUrl);
	        
	        
	       // String header = response.getHeader("location");
	        String header = response.getHeader("location");
	        
	       // String authCode = response.path("code");
	        
	        System.out.println(header+"Sadcqsdqs");
	       // System.out.println(authCode+"Sad2ed2wken2cqsdqs");
	        
	        
	        
//	        try {
//				Desktop.getDesktop().browse(new URI(authorizationUrl));
//			} catch (IOException | URISyntaxException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

	        // Read the authorization code from the user
//	        Scanner scanner = new Scanner(System.in);
//	        String authorizationCode = scanner.nextLine();
//	        scanner.close();
//            System.out.println(authorizationCode);
             // return authorizationCode;
	        return null;
	    }

	 public static void main(String[] args) {
		modularization.getAuthorizationCode();
	}
	 
}
