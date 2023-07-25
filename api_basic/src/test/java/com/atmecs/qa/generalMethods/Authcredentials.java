package com.atmecs.qa.generalMethods;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Authcredentials {
	
	
	
	
	private static final String APPLICATION_NAME = "PostmanOauth ";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final List<String> SCOPES = Collections.singletonList(GmailScopes.MAIL_GOOGLE_COM);
    private static final String CREDENTIALS_FILE_PATH = System.getProperty("user.dir") +
            File.separator + "src" +
            File.separator + "test" +
            File.separator + "resources" +
            File.separator + "credentials.json";

    private static final String TOKENS_DIRECTORY_PATH = System.getProperty("user.dir") +
            File.separator + "src" +
            File.separator + "test" +
            File.separator + "resources" +
            File.separator + "credentials";

    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        InputStream in = new FileInputStream(new File(CREDENTIALS_FILE_PATH));
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(9999).build();
        
        System.out.println(receiver.toString());
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public static String getAccessToken() throws IOException, GeneralSecurityException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        Credential credential = getCredentials(HTTP_TRANSPORT);
        String accessToken = credential.getAccessToken();

        return accessToken;
    }
	
    @Test
    public void OAuth() throws IOException, GeneralSecurityException {
    	
    	String payload="\"{\\\"message\\\":{\\\"raw\\\":\\\"VGhpcyBpcyBhIHRlc3QgZnJvbSBhIGRyYWZ0IG1lc3NhZ2Uu\\\"}}\"";
        
        String auth = Authcredentials.getAccessToken();
        //logger.info(auth);
        System.out.println(auth);
        
        String asPrettyString = RestAssured.given()
                .auth()
                .oauth2(auth)   
                .get("https://gmail.googleapis.com/gmail/v1/users/arivarasan.arivudainambi@atmecs.com/messages")
                .asPrettyString();
        
        System.out.println(asPrettyString);
        
       // logger.info(res.asPrettyString());
        
    }

}
