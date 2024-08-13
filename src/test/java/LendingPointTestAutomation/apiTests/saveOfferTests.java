package LendingPointTestAutomation.apiTests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import org.testng.ITestContext;

import LendingPointTestAutomation.baseClass.BaseClass;
import io.restassured.RestAssured;

public class saveOfferTests extends BaseClass{

qualifyAPITests qualifyAPITests;

	@Test (groups = {"APISmokeSuite"})
	public void saveOfferSuccess(ITestContext context) {
		qualifyAPITests = new qualifyAPITests();
		qualifyAPITests.returnQualifyResponse(context);
		String offerId = (String) context.getAttribute("offerId");
		RestAssured.given().log().all()
			.baseUri(prop.getProperty("apiEnvironmentUrl"))
			.basePath("/api/lead/saveOffer/"+offerId)
			.queryParam("isSelected", true)
			.queryParam("key", "xHvLmlZ3wPt2oBOPMV7g7U65ZvG8P%2F4V22l1aASRAuWrSxr0x9Oqm4Nb6DCJCAKF")
			.urlEncodingEnabled(false)
			.contentType("application/json")
			.accept("application/json")
			.header("Exchange-Format","Core")
		.when().get()
		.then().log().all()
		.statusCode(200)
		.body("offerId" , equalTo(offerId))
		.body("status" , equalTo("Pass"))
		.body("message" , equalTo("Successfully saved"))
		.body("offerStatus" , equalTo("Pass"))
		.body("offerMessage" , equalTo("Pass"));
	}
}
