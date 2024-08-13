package LendingPointTestAutomation.apiTests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import LendingPointTestAutomation.baseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

public class qualifyAPITests extends BaseClass{
	
	public void qualifySuccessHit() {
		RestAssured.baseURI = prop.getProperty("apiEnvironmentUrl");
		String path = "api/lead/qualify";
		String json = "{" +
        "   \"firstName\":\"JOHN\",\n" +
        "   \"lastName\":\"SMITH\",\n" +
        "   \"zip\":\"30318\",\n" +
        "   \"phone\":\"2127290854\",\n" +
        "   \"street\":\"222333 PEACHTREE PLACE\",\n" +
        "   \"city\":\"ATLANTA\",\n" +
        "   \"state\":\"GA\",\n" +
        "   \"useOfFunds\":\"Moving\",\n" +
        "   \"loanAmount\":\"15000\",\n" +
        "   \"annualIncome\":\"180000\",\n" +
        "   \"email\":\"no+87687676@lendingpoint.com\",\n" +
        "   \"dob\":\"02/28/1975\",\n" +
        "   \"authToPullCredit\":\"true\",\n" +
        "   \"ssn\":\"112223333\",\n" +
        "   \"timeAtCurrentAddress\":\"08/10/2013\",\n" +
        "   \"campaignId\":\"CAMPTEST123\",\n" +
        "   \"unit\":\"33\",\n" +
        "   \"loanPurpose\":\"Test Loan\",\n" +
        "   \"source\":\"Organic\",\n" +
        "   \"subSource\":\"LPCustomerPortal\",\n" +
        "   \"subProvider\":\"LPCustomerPortal\"\n" +
        "}";
		RequestSpecification request = RestAssured.given();
		request.body(json);
		request.headers("Exchange-Format", "Core");
		request.headers("Content-Type", "application/json");
		request.headers("Accept", "application/json");
		request.headers("Connection", "keep-alive");
		request.headers("Host", "qaapi.lendingpoint.com");
		Response response = request.urlEncodingEnabled(false).queryParam("key", "xHvLmlZ3wPt2oBOPMV7g7U65ZvG8P%2F4V22l1aASRAuWrSxr0x9Oqm4Nb6DCJCAKF").post(path);
		AssertJUnit.assertEquals(response.statusCode(), 200);
	}
	
	@Test (groups = "APISmokeSuite")
	public void newACHService() {
		RestAssured.baseURI = "https://api-int.lendpt.app/";
		String path = "api/payment-generation/v1/700170/process?targetDate=2024-05-25&canSave=true";
		RequestSpecification request = RestAssured.given();
		request.headers("Content-Type", "application/json");
		request.headers("Accept", "application/json");
		Response response = request.post(path);
		System.out.println(response.statusCode());
		System.out.println(response.getBody().asString());
	}
	
	@Test (groups = "APISmokeSuite")
	public void qualifySuccessTest() {
		requestParam.put("firstName", "JOHN");
		requestParam.put("lastName", "SMITH");
		requestParam.put("zip", "30318");
		requestParam.put("phone", "2127290854");
		requestParam.put("street", "222333 PEACHTREE PLACE");
		requestParam.put("city", "ATLANTA");
		requestParam.put("state", "GA");
		requestParam.put("useOfFunds", "Moving");
		requestParam.put("loanAmount", "5000");
		requestParam.put("annualIncome", "98000");
		requestParam.put("email", "no+3221376@lendingpoint.com");
		requestParam.put("dob", "02/28/1975");
		requestParam.put("authToPullCredit", "true");
		requestParam.put("ssn", "112223333");
		requestParam.put("timeAtCurrentAddress", "08/10/2013");
		requestParam.put("loanPurpose", "Test Loan");
		requestParam.put("campaignId", "CAMPTEST123");
		requestParam.put("source", "Organic");
		requestParam.put("subSource", "LPCustomerPortal");
		requestParam.put("subProvider", "LPCustomerPortal");
		
		RestAssured.given()
			.baseUri(prop.getProperty("apiEnvironmentUrl"))
			.basePath("/api/lead/qualify")
			.queryParam("key", "xHvLmlZ3wPt2oBOPMV7g7U65ZvG8P%2F4V22l1aASRAuWrSxr0x9Oqm4Nb6DCJCAKF")
			.urlEncodingEnabled(false)
			.contentType("application/json")
			.accept("application/json")
			.header("Exchange-Format","PointOfNeed")
			.header("Connection","keep-alive")
			.header("Host","qaapi.lendingpoint.com")
			.body(requestParam)
			.log().all()
			
		.when()
			.post()
		
		.then().log().all()
			.statusCode(200)
			.body("offerStatus" , equalTo("200"))
			.body("offerMessage",equalTo("200"))
			.body("status", equalTo("200"))
			.body("message", equalTo("Lead Created Successfully"))
			.body("response", equalTo("Accept"))
			.body("offers[0].criteria", equalTo(null))
			.body("offers[0].offerUrl", containsString("https://qamain.lendingpoint.com/apply/#/PartnersOffer"));
		requestParam.clear();
	}
	
	public void returnQualifyResponse(ITestContext context) {
		requestParam.put("firstName", "JOHN");
		requestParam.put("lastName", "SMITH");
		requestParam.put("zip", "30318");
		requestParam.put("phone", "2127290854");
		requestParam.put("street", "222333 PEACHTREE PLACE");
		requestParam.put("city", "ATLANTA");
		requestParam.put("state", "GA");
		requestParam.put("useOfFunds", "Moving");
		requestParam.put("loanAmount", "5000");
		requestParam.put("annualIncome", "98000");
		requestParam.put("email", "no+3221376@lendingpoint.com");
		requestParam.put("dob", "02/28/1975");
		requestParam.put("authToPullCredit", "true");
		requestParam.put("ssn", "112223333");
		requestParam.put("timeAtCurrentAddress", "08/10/2013");
		requestParam.put("loanPurpose", "Test Loan");
		requestParam.put("campaignId", "CAMPTEST123");
		requestParam.put("source", "Organic");
		requestParam.put("subSource", "LPCustomerPortal");
		requestParam.put("subProvider", "LPCustomerPortal");
		
		Response response = RestAssured.given()
			.baseUri(prop.getProperty("apiEnvironmentUrl"))
			.basePath("/api/lead/qualify")
			.queryParam("key", "xHvLmlZ3wPt2oBOPMV7g7U65ZvG8P%2F4V22l1aASRAuWrSxr0x9Oqm4Nb6DCJCAKF")
			.urlEncodingEnabled(false)
			.contentType("application/json")
			.accept("application/json")
			.header("Exchange-Format","PointOfNeed")
			.header("Connection","keep-alive")
			.header("Host","qaapi.lendingpoint.com")
			.body(requestParam)
			.log().all()
			
		.when()
			.post()
		
		.then()
			.log().all()
			.extract()
			.response();
		JsonPath jsonPath = response.jsonPath();
		String offerId = jsonPath.get("offers[0].id");
		String leadId = jsonPath.get("lead.leadId");
		String applicationId = jsonPath.get("lead.applicationId");
		context.setAttribute("offerId", offerId);
		context.setAttribute("leadId", leadId);
		context.setAttribute("applicationId", applicationId);
		requestParam.clear();
	}

}
