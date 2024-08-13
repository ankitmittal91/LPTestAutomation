package LendingPointTestAutomation.apiTests;

import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import LendingPointTestAutomation.baseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class applyFundingFlow extends BaseClass{

String offerId, leadId, applicationId;
	@Test (priority = 1, groups = "APISmokeSuite")
	public void qualifyAPITest() {
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
							.when().post();
		response.prettyPrint();
		JsonPath jsonResponse = response.jsonPath();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(jsonResponse.getString("offerStatus"), "200");
		Assert.assertEquals(jsonResponse.getString("offerMessage"), "200");
		Assert.assertEquals(jsonResponse.getString("status"), "200");
		Assert.assertEquals(jsonResponse.getString("message"), "Lead Created Successfully");
		Assert.assertEquals(jsonResponse.getString("response"), "Accept");
		Assert.assertEquals(jsonResponse.getString("offers[0].criteria"), null);
		Assert.assertTrue(jsonResponse.getString("offers[0].offerUrl").contains("https://qamain.lendingpoint.com/apply/#/PartnersOffer"));
		offerId = jsonResponse.getString("offers[0].id");
		leadId = jsonResponse.getString("lead.leadId");
		applicationId = jsonResponse.getString("lead.applicationId");
		requestParam.clear();
	}
	
	@Test (priority = 2, groups = "APISmokeSuite")
	public void saveOfferAPITest() {
		Response response = RestAssured.given()
					.baseUri(prop.getProperty("apiEnvironmentUrl"))
					.basePath("/api/lead/saveOffer/"+offerId)
					.queryParam("isSelected", true)
					.queryParam("key", "xHvLmlZ3wPt2oBOPMV7g7U65ZvG8P%2F4V22l1aASRAuWrSxr0x9Oqm4Nb6DCJCAKF")
					.urlEncodingEnabled(false)
					.contentType("application/json")
					.accept("application/json")
					.header("Exchange-Format","Core")
					.log().all()
					.when().get();
		response.prettyPrint();
		JsonPath jsonResponse = response.jsonPath();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(jsonResponse.getString("offerId"), offerId);
		Assert.assertEquals(jsonResponse.getString("status"), "Pass");
		Assert.assertEquals(jsonResponse.getString("message"), "Successfully saved");
		Assert.assertEquals(jsonResponse.getString("offerStatus"), "Pass");
		Assert.assertEquals(jsonResponse.getString("offerMessage"), "Pass");
	}
	
	@Test (priority = 3, groups = "APISmokeSuite")
	public void idologyAPITests() {
		requestParam.put("firstName", "JOHN");
		requestParam.put("lastName", "SMITH");
		requestParam.put("zip", "30318");
		requestParam.put("phone", "2127290854");
		requestParam.put("street", "222333 PEACHTREE PLACE");
		requestParam.put("city", "ATLANTA");
		requestParam.put("state", "GA");
		requestParam.put("email", "no@lendingpoint.com");
		requestParam.put("dob", "02/28/1975");
		requestParam.put("authToPullCredit", "true");
		requestParam.put("ssn", "112223333");
		
		Response response = RestAssured.given()
							.baseUri(prop.getProperty("apiEnvironmentUrl"))
							.basePath("thirdParty/idology/questions")
							.queryParam("key", "xHvLmlZ3wPt2oBOPMV7g7U65ZvG8P%2F4V22l1aASRAuWrSxr0x9Oqm4Nb6DCJCAKF")
							.queryParam("appId", applicationId)
							.urlEncodingEnabled(false)
							.contentType("application/json")
							.accept("application/json")
							.body(requestParam)
							.log().all()
							.when().post();
		response.prettyPrint();
		JsonPath jsonResponse = response.jsonPath();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(jsonResponse.getString("summaryResult.message"), "OPTIONAL");
		Assert.assertEquals(jsonResponse.getString("summaryResult.key"), "id.success");
		requestParam.clear();
	}
	
	@Test (priority = 4, groups = "APISmokeSuite")
	public void saveLoanPaymentDetailAPITest() {
		requestParam.put("oneTimePayment", "false");
		requestParam.put("bankName", "Bank of America");
		requestParam.put("paymentMethod", "ACH");
		requestParam.put("authHardCreditPull", "true");
		requestParam.put("accountNumber", "0000000019");
		requestParam.put("routingNumber", "122105278");
		requestParam.put("appId", applicationId);
		
		Response response = RestAssured.given()
							.baseUri(prop.getProperty("apiEnvironmentUrl"))
							.basePath("applyDashboard/saveLoanPaymentDetails")
							.queryParam("key", "xHvLmlZ3wPt2oBOPMV7g7U65ZvG8P%2F4V22l1aASRAuWrSxr0x9Oqm4Nb6DCJCAKF")
							.urlEncodingEnabled(false)
							.contentType("application/json")
							.accept("application/json")
							.body(requestParam)
							.log().all()
							.when().post();
		JsonPath jsonResponse = response.jsonPath();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(jsonResponse.getString("status"), "200");
		Assert.assertEquals(jsonResponse.getString("message"), "success");
		requestParam.clear();
	}
	
	@Test (priority = 5)
	public void giactVerificationAPITest() {
		Response response = RestAssured.given()
							.baseUri("https://io-qa.lendingpoint.com")
							.basePath("trantor/applyDashboard/verifyBankDetailsUsingGIACT")
							.queryParam("appId", applicationId)
							.urlEncodingEnabled(false)
							.contentType("application/json")
							.accept("application/json")
							.header("Authorization" , "xHvLmlZ3wPt2oBOPMV7g7U65ZvG8P%2F4V22l1aASRAuWrSxr0x9Oqm4Nb6DCJCAKF")
							.log().all()
							.when().get();
		JsonPath jsonResponse = response.jsonPath();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(jsonResponse.getString("message") , "Verification Passed");
		Assert.assertEquals("success", "true");
		Assert.assertEquals("status", "200");
	}
	
	@Test (priority = 6)
	public void saveEmploymentDetailAPITest() {
		requestParam.put("employerName", "Test EmployerName");
		requestParam.put("employeeStatus", "Test EmployerName");
		requestParam.put("employerPhone", "Test EmployerName");
		requestParam.put("startDate", "Test EmployerName");
		requestParam.put("companyName", "Test EmployerName");
		requestParam.put("companyPhone", "Test EmployerName");
		requestParam.put("appId", applicationId);
		Response response = RestAssured.given()
							.baseUri("apiEnvironmentUrl")
							.basePath("applyDashboard/saveEmploymentDetails")
							.queryParam("key", "xHvLmlZ3wPt2oBOPMV7g7U65ZvG8P%2F4V22l1aASRAuWrSxr0x9Oqm4Nb6DCJCAKF")
							.urlEncodingEnabled(false)
							.contentType("application/json")
							.accept("application/json")
							.body(requestParam)
							.log().all()
							.when().post();
		JsonPath jsonResponse = response.jsonPath();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(jsonResponse.getString("message"), "Employment Information saved Successfully");
		Assert.assertEquals(jsonResponse.getString("regradeNeeded"), "false");
		Assert.assertEquals(jsonResponse.getString("status"), "200");
	}

}
