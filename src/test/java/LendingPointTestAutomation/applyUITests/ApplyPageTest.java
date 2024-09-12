package LendingPointTestAutomation.applyUITests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.*;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.dataProvider.DataProviders;
import LendingPointTestAutomation.pageFactory.applyNewUI.*;
import LendingPointTestAutomation.utility.DriverFactory;
import LendingPointTestAutomation.utility.Log;

public class ApplyPageTest extends BaseClass {

ApplyPage applyPage;
ApplyDetailsContactInfoPage applyDetailsContactInfoPage;
IncomeAddressFillPage incomeAddressFillPage;
VerifyPhone verifyPhone;
YourIncomePage yourIncomePage;
AboutYouDOBSSNPage aboutYouDOBSSNPage;
selectOfferPage selectOfferPage;
offerConfirmPage offerConfirmPage;
connectDepositAccountPage connectDepositAccountPage;

	@BeforeMethod (groups = {"Sanity","Smoke","APISmokeSuite"})
	public void launchApplication() {
		launchBrowser(prop.getProperty("newApplyUIUrl"));
		applyPage = new ApplyPage();
		Action.fluentWait(applyPage.firstNameTextBox, 30);
	}

	@AfterMethod (groups = {"Sanity","Smoke","APISmokeSuite"})
	public void tearDown() {
		if(DriverFactory.getInstance().getDriver() != null) {
			DriverFactory.getInstance().closeBrowser();
		}
	}
	
	@Test (dataProvider = "userData", dataProviderClass = DataProviders.class , groups = {"Sanity","Smoke"}, priority =1)
	public void newApplyFundingFlow(Map<String,String> map) throws InterruptedException {
			Log.startTestCase("User starts entering Personal Information");
		applyPage.enterFirstName(map.get("First Name"));
		applyPage.enterLastName(map.get("Last Name"));
		applyPage.enterLoanAmount(map.get("Loan Amount"));
		applyPage.selectLoanPurpose();
		applyDetailsContactInfoPage = applyPage.clickContinueButton();
			Action.fluentWait(applyDetailsContactInfoPage.mobilePhoneTextBox, 10);
		applyDetailsContactInfoPage.enterMobilePhone("7543074253");
		applyDetailsContactInfoPage.enterEmail(map.get("Email Address"));
		verifyPhone = applyDetailsContactInfoPage.clickContinueButton();
			Action.fluentWait(verifyPhone.codeTextBox1, 10);
		verifyPhone.enterVerificationCode("123456");
		incomeAddressFillPage = verifyPhone.clickVerifyButton();
			Action.fluentWait(incomeAddressFillPage.addressTextBox, 20);
		incomeAddressFillPage.enterAddress(map.get("Address"));
		incomeAddressFillPage.enterCity(map.get("City"));
		incomeAddressFillPage.selectState(map.get("State"));
		incomeAddressFillPage.enterZip(map.get("Zip"));
		yourIncomePage = incomeAddressFillPage.clickContinuetoIncomeButton();
			Action.fluentWait(yourIncomePage.annualIncomeTextBox, 10);
		yourIncomePage.enterAnnualIncome(map.get("Annual Income"));
		yourIncomePage.selectIncomeType(map.get("Income Type"));
			Action.fluentWait(yourIncomePage.companyNameTextBox, 10);
		yourIncomePage.enterCompanyName(map.get("Company Name"));
		aboutYouDOBSSNPage = yourIncomePage.clickContinueToAboutYouButton();
			Action.fluentWait(aboutYouDOBSSNPage.dobTextBox, 10);
		aboutYouDOBSSNPage.enterDOB(map.get("DOB"));
		aboutYouDOBSSNPage.enterSSN(map.get("SSN"));
		selectOfferPage = aboutYouDOBSSNPage.clickSeeOptionsButton();
			DriverFactory.getInstance().getDriver().manage().timeouts().wait(30000);
			Action.fluentWait(selectOfferPage.congratulationsText, 60);
		offerConfirmPage = selectOfferPage.clickConfirmOfferButton();
			Action.fluentWait(offerConfirmPage.offerConfirmedText, 60);
		connectDepositAccountPage = offerConfirmPage.clickLetsGoButton();
			Action.fluentWait(connectDepositAccountPage.connectDepositAccountText, 60);
		connectDepositAccountPage.clickConnectBankButton();
		Log.endTestCase("User finished entering Personal Information");
	}
	
	@Test (dataProvider = "userData", dataProviderClass = DataProviders.class , groups = {"Sanity","Smoke"}, priority =2)
	public void newApplyFundingFlow1(String firstName, String lastName, String loanAmount, String mobilePhone, String email, String address, String city, String state, String zip, String annualIncome, String incomeType, String companyName, String dob, String ssn) throws InterruptedException {
			Log.startTestCase("User starts entering Personal Information");
		applyPage.enterFirstName(firstName);
		applyPage.enterLastName(lastName);
		applyPage.enterLoanAmount(loanAmount);
		applyPage.selectLoanPurpose();
		applyDetailsContactInfoPage = applyPage.clickContinueButton();
			Action.fluentWait(applyDetailsContactInfoPage.mobilePhoneTextBox, 10);
		applyDetailsContactInfoPage.enterMobilePhone("7543074253");
		applyDetailsContactInfoPage.enterEmail(email);
		verifyPhone = applyDetailsContactInfoPage.clickContinueButton();
			Action.fluentWait(verifyPhone.codeTextBox1, 10);
		verifyPhone.enterVerificationCode("123456");
		incomeAddressFillPage = verifyPhone.clickVerifyButton();
			Action.fluentWait(incomeAddressFillPage.addressTextBox, 20);
		incomeAddressFillPage.enterAddress(address);
		incomeAddressFillPage.enterCity(city);
		incomeAddressFillPage.selectState(state);
		incomeAddressFillPage.enterZip(zip);
		yourIncomePage = incomeAddressFillPage.clickContinuetoIncomeButton();
			Action.fluentWait(yourIncomePage.annualIncomeTextBox, 10);
		yourIncomePage.enterAnnualIncome(annualIncome);
		yourIncomePage.selectIncomeType(incomeType);
			Action.fluentWait(yourIncomePage.companyNameTextBox, 10);
		yourIncomePage.enterCompanyName(companyName);
		aboutYouDOBSSNPage = yourIncomePage.clickContinueToAboutYouButton();
			Action.fluentWait(aboutYouDOBSSNPage.dobTextBox, 10);
		aboutYouDOBSSNPage.enterDOB(dob);
		aboutYouDOBSSNPage.enterSSN(ssn);
		selectOfferPage = aboutYouDOBSSNPage.clickSeeOptionsButton();
			DriverFactory.getInstance().getDriver().manage().timeouts().wait(30000);
			Action.fluentWait(selectOfferPage.congratulationsText, 60);
		offerConfirmPage = selectOfferPage.clickConfirmOfferButton();
			Action.fluentWait(offerConfirmPage.offerConfirmedText, 60);
		connectDepositAccountPage = offerConfirmPage.clickLetsGoButton();
			Action.fluentWait(connectDepositAccountPage.connectDepositAccountText, 60);
		connectDepositAccountPage.clickConnectBankButton();
		Log.endTestCase("User finished entering Personal Information");
	}
}
