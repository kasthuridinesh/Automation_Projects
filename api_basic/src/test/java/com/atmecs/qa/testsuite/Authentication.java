package com.atmecs.qa.testsuite;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.qa.generalMethods.AuthentictaionMethods;

import com.atmecs.qa.dto.DataTranfers;

public class Authentication extends AuthentictaionMethods{
	static Logger logger = Logger.getLogger(Authentication.class);

	AuthentictaionMethods utilities = new AuthentictaionMethods();

	// BasicAuth Data
	String basicAuthBaseUrl = DataTranfers.basicAuthUrl;
	String basicAuthUsername = DataTranfers.basicAuthUsername;
	String basicAuthBasePassword = DataTranfers.basicAuthPassword;

	// ApiKey Data
	String ApiKeyBaseUrl = DataTranfers.ApiKeyUrl;
	String ApiKeyValue = DataTranfers.ApiKeyValue;

	// BearerToken Data
	String BearerTokenBaseUrl = DataTranfers.BearerUrl;
	String BearerTokenValue = DataTranfers.BearerTokenValue;

	// OauthBearerToken Data
	String OauthBearerTokenBaseUrl = DataTranfers.OauthUrl;
	String oauthBearerTokenposturl = DataTranfers.OauthUrldraft;
	// String OauthBearerTokenValue=DataTranfer.OauthBearerTokenValue;

//	@BeforeTest
//	public void config() {
//
//		PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
//				+ File.separator + "resources" + File.separator + "logs" + File.separator + "log4j.properties");
//	}

	@Test
	public void AuthMethods() {
// 	utilities.apiKeyauth(ApiKeyBaseUrl, ApiKeyValue);
		utilities.basicAuth(basicAuthBaseUrl, basicAuthUsername, basicAuthBasePassword);
//		utilities.bearerTokenauth(BearerTokenBaseUrl, BearerTokenValue);
		// utilities.Oauth2auth(OauthBearerTokenBaseUrl);
		// utilities.Oauth2authPost(oauthBearerTokenposturl);
		// utilities.getAcessToken();
		// utilities.getAuthorizationCode();
		// String extractAuthorizationCode =
		// utilities.extractAuthorizationCode("https://oauth.pstmn.io/v1/callback?code=4/0AbUR2VM1PraBnZ3k4V8Vy4aSGFR7sNxByoqKMNbvT821Jp40W7Ho28083BFppEOSCIvq1w&scope=https://mail.google.com/");
		// System.out.println(extractAuthorizationCode);
		//logger.info("Hii");
	}

}
