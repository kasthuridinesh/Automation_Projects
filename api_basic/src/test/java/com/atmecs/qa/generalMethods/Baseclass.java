package com.atmecs.qa.generalMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Baseclass {



	 Logger logger = Logger.getLogger(Baseclass.class);
	 
	// Baseclass base=new Baseclass();
	/*
	 * Methode Description : Log4j configuration 
	 * 
	 * Author :Arivarasan A
	 * */
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

	/**
	 * 
	 * Methode Description : Read Value From property File.
	 * @created 17-05-2023
	 * @param resourcekey key in property file
	 * @return propertyvalue as String
	 * @author Arivarasan A
	 * @throws FileNotFoundException
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

			value = properties.getProperty(resourcekey);

			logger.info("Sucessfully read data from the property file ="+value);
			return value;
		} catch (IOException e) {
			logger.error("failed to read data from the property file"+e);
		} finally {
			// Close the input stream
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					logger.error("failed to find the property file"+e);
				}
			}
		}
		return null;

	}

	/**
	 * It read the given JSON and give the json data
	 * @created 17-05-2023
	 * @param Location
	 * @return jsonData as String
	 * @author Arivarasan A
	 * @throws FileNotFoundException
	 */

	public  JSONObject readJsonFile(String location) throws FileNotFoundException {

		try {

			InputStream input = new FileInputStream(location);
			JSONTokener tokener = new JSONTokener(input);
			JSONObject jsonObject = new JSONObject(tokener);
			logger.info("Json file reading is completed");
			return jsonObject;

		} catch (Exception exception) {
			logger.error("Json file reading is not completed");
		}

		return null;
	}



	/**
	 * Provide requestSpecification for No Authorization.
	 * @param: username.
	 * @param:password.
	 * @return requestSpecification
	 * @author Arivarasan A
	 * 
	 * */


	public RequestSpecification noAuth() {
		try {
			logger.info("Response gathered from server for the  noAuth Authentication");
			return RestAssured.given().log().all();


		} catch (Exception e) {
			logger.error("failed to provide the requestSpecification from Basic Authorization" + e);
		}
		return null;

	}

	/**
	 * Provide requestSpecification for basic Authorization.
	 * @param: username.
	 * @param:password.
	 * @return requestSpecification
	 * @author Arivarasan A
	 * 
	 * */
	public RequestSpecification basicAuth(String username, String password) {
		try {
			logger.info("Response gathered from server for the  Basic Authentication");
			return RestAssured.given().auth().basic(username, password);


		} catch (Exception e) {
			logger.error("failed to provide the requestSpecification from Basic Authorization" + e);
		}
		return null;

	}

	/**
	 * Provide requestSpecification for apikey Authorization. 
	 * @param: username.
	 * @param:password.
	 * @return requestSpecification
	 * @author Arivarasan A
	 * 
	 * */
	public RequestSpecification apiKeyAuth(String apikey,String apikeyToken) {
		try {
			logger.info("Response gathered from server for the  Apikey Authentication");
			return RestAssured.given().queryParam(apikey, apikeyToken);

		} catch (Exception e) {
			logger.error("failed to provide the requestSpecification from Apikey Authorization" + e);
		}
		return null;

	}

	/**
	 * Provide requestSpecification for apikey Authorization. 
	 * @param: username.
	 * @param:password.
	 * @return requestSpecification
	 * @author Arivarasan A
	 * 
	 * */
	public RequestSpecification BearerAuth(String apikey,String apikeyToken) {
		try {
			logger.info("Response gathered from server for the  BearerAuth Authentication");
			return RestAssured.given().header(apikey, apikeyToken);

		} catch (Exception e) {
			logger.error("failed to provide the requestSpecification from BearerAuth Authorization" + e);
		}
		return null;

	}

	/**
	 * Provide requestSpecification for OAuth2 Authorization.
	 * @param: username.
	 * @param:password.
	 * @return requestSpecification
	 * @author Arivarasan A
	 * 
	 * */
	public RequestSpecification OAuth2(String accessToken) {
		try {
			logger.info("Response gathered from server for the  OAuth2 Authentication");
			return RestAssured.given().auth().oauth2(accessToken);


		} catch (Exception e) {
			logger.error("failed to provide the requestSpecification from OAuth2 Authorization" + e);
		}
		return null;

	}
	/**
	 * Provide requestSpecification for pathParameters.
	 * @param: requestspec.
	 * @param:pathparamsValue.
	 * @return requestSpecification
	 * @author Arivarasan A
	 * 
	 * */

	public RequestSpecification pathParameter(RequestSpecification requestspec,String pathparamsKey,String pathparamsValue ) {

		try {
			logger.info("Pathparameter section providing");
			return requestspec.contentType(ContentType.JSON).pathParam(pathparamsKey,pathparamsValue);
			

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * Provide requestSpecification for pathParameters.
	 * @param: requestspec.
	 * @param:pathparamsValue.
	 * @return requestSpecification
	 * @author Arivarasan A
	 * 
	 * */

	public RequestSpecification queryParameter(RequestSpecification requestspec,String paramsKey,String paramsValue ) {

		try {
			logger.info("Queryparameter section providing");
			return requestspec.queryParam(paramsKey,paramsValue);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * Provide requestSpecification for withMultiValueParameters.
	 * @param: parameterName.
	 * @param:parameterValues.
	 * @return requestSpecification
	 * @author Arivarasan A
	 * 
	 * */

	public static RequestSpecification withMultiValueParameters(RequestSpecification requestSpec, String parameterName,
			List<String> parameterValues) {

		try {
			for (String value : parameterValues) {
				requestSpec.queryParam(parameterName, value);
			}
			return requestSpec;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Provide requestSpecification for pathParameters.
	 * @param: requestspec.
	 * @param:pathparamsValue.
	 * @return requestSpecification
	 * @author Arivarasan A
	 * 
	 * */

	public RequestSpecification requestBody(RequestSpecification requestspec,String bodyValue ) {

		try {
			logger.info("Pathparameter section providing");
			return requestspec.body(bodyValue);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public String reaponsePropertyReader(Response response,String propertyKey) {
		String propertyValue;
		try {

			propertyValue=response.getBody().jsonPath().getString(propertyKey);
			//			ObjectMapper objectMapper = new ObjectMapper();
			//			JsonNode jsonNode = objectMapper.readTree(responseBody);
			//
			//			// Extract the property value
			//			propertyValue = jsonNode.get(propertyKey).asText();
			return propertyValue;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	public String getAcessToken(String accesstokenURL,String clientId,String clientSecret,String grantType,
			String authorizationCode,String scope,String callBackUrl) {
		String access_tokenName=null;
		try {

			Response response =RestAssured.given()
					.auth().preemptive()// CHECK THE AUTH INFO
					.basic(clientId,clientSecret)
					.param("grant_type",grantType)
					.param("code", authorizationCode)
					.param("scope", scope)
					.param("redirect_uri", callBackUrl)
					.log().all()
					.post(accesstokenURL);
			response.prettyPrint();
			access_tokenName=response.getBody().path("access_token");           
			logger.info("sucessfully generated the acess token"+access_tokenName);
			return access_tokenName;
		} catch (Exception e) {
			logger.info("Failed to generated the acess token"+access_tokenName);
		}
		return access_tokenName;

	}

	public  String getAuthorizationCode() {

		String AuthendPoint="https://accounts.google.com/o/oauth2/auth";
		String clientID="392601246463-m6q4k8u1s9k562jlp59k423nps91mh2p.apps.googleusercontent.com";
		String redirectUrl="https://oauth.pstmn.io/v1/callback";
		String emailID="arivarasan.arivudainambi@atmecs.com";

		try {
			// Build the authorization URL
			String authorizationUrl = AuthendPoint + "?response_type=code"
					+ "&client_id=" + clientID
					+ "&redirect_uri=" + redirectUrl
					+ "&scope=https://mail.google.com/"
					+"&login_hint="+emailID;

			System.out.println("Please authorize the application by visiting the following URL:");
			System.out.println(authorizationUrl);
			System.out.println("Enter the authorization code:");
			Scanner scanner = new Scanner(System.in);
			String authorizationCode = scanner.nextLine();
			scanner.close();
			logger.info("Generated Authorization= "+authorizationCode);
			return authorizationCode;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public String localeDate() {
		String formattedDateTime=null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			ZonedDateTime currentDateTime = ZonedDateTime.now(ZoneOffset.UTC);
			formattedDateTime = currentDateTime.format(formatter);
			System.out.println("Formatted date and time: " + formattedDateTime);
            return formattedDateTime;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public String retrieveData(String testCaseID,String sheetName,String keyname) {
		
		String excpectedValue=null;
		try {
			
			HashMap<String, String> readExcelData= readExcelFile(testCaseID, sheetName);
			excpectedValue=readExcelData.get(keyname);
			logger.info("Sucessfully read data from excel="+excpectedValue);
			return excpectedValue;
			
		} catch (Exception e) {
			logger.info("Failed to read data from excel="+excpectedValue);
		}
		return excpectedValue;
	}
	
	
	public  HashMap<String, String> readExcelFile(String testCaseID, String sheetName) {

        HashMap<String, String> rowData = null;

        try {
        	
        	String path=System.getProperty("user.dir") + File.separator + "data"
        			     +File.separator+"ApiTestData.xlsx";

            FileInputStream file = new FileInputStream(path);

            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet(sheetName);
            sheet.getActiveCell();

            rowData = new LinkedHashMap<String, String>();
            String value = null;
            for (int row = 0; row <= sheet.getLastRowNum(); row++) {
                String testCase = sheet.getRow(row).getCell(0).getStringCellValue();
                if (testCase.contains(testCaseID)) {                  
                    for (int index = 1; index < sheet.getRow(0).getLastCellNum(); index++) {
                        String key = sheet.getRow(0).getCell(index).getStringCellValue();
                        Cell cellValue = sheet.getRow(row).getCell(index);
                        if (cellValue != null) {
                            value = new DataFormatter().formatCellValue(cellValue);
                        }
                        rowData.put(key, value);              
                    }
                }
            }
            workbook.close();
            logger.info("Excel read is performed");
        } catch (Exception exception) {
            logger.error("Excel read is not performed : " + exception);
        }
        return rowData;
    }
	
	public void schemaValidation(Response response,String location)
    {
        try {
			File file = new File (location);
			ValidatableResponse body = response.then().body(JsonSchemaValidator.matchesJsonSchema(file));
			System.out.println("sucessfully validated the schema:"+body);
		} catch (Exception e) {
			logger.info("Failed to validated the schema:"+e);
		}
    }	
	
}
