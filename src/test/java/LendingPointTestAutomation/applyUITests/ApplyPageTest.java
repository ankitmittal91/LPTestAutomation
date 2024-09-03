package LendingPointTestAutomation.applyUITests;

import org.testng.Assert;
import org.testng.annotations.*;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.dataProvider.DataProviders;
import LendingPointTestAutomation.pageFactory.applyNewUI.*;
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
		launchBrowser(prop.getProperty("newApplyUIUrl"), prop.getProperty("browserType"));
		applyPage = new ApplyPage();
		Action.fluentWait(getDriver(), applyPage.firstNameTextBox, 30);
	}

	@AfterMethod (groups = {"Sanity","Smoke","APISmokeSuite"})
	public void tearDown() {
		if(getDriver() != null) {
			getDriver().quit();
		}
	}
	
	@Test (dataProvider = "userData", dataProviderClass = DataProviders.class , groups = {"Sanity","Smoke"})
	public void newApplyFundingFlow(String firstName, String lastName, String loanAmount, String mobilePhone, String email, String address, String city, String state, String zip, String annualIncome, String incomeType, String companyName, String dob, String ssn) throws InterruptedException {
			Log.startTestCase("User starts entering Personal Information");
		applyPage.enterFirstName(firstName);
		applyPage.enterLastName(lastName);
		applyPage.enterLoanAmount(loanAmount);
		applyPage.selectLoanPurpose();
		applyDetailsContactInfoPage = applyPage.clickContinueButton();
			Action.fluentWait(getDriver(), applyDetailsContactInfoPage.mobilePhoneTextBox, 10);
		applyDetailsContactInfoPage.enterMobilePhone("7543074253");
		applyDetailsContactInfoPage.enterEmail(email);
		verifyPhone = applyDetailsContactInfoPage.clickContinueButton();
			Action.fluentWait(getDriver(), verifyPhone.codeTextBox1, 10);
		verifyPhone.enterVerificationCode("123456");
		incomeAddressFillPage = verifyPhone.clickVerifyButton();
			Action.fluentWait(getDriver(), incomeAddressFillPage.addressTextBox, 20);
		incomeAddressFillPage.enterAddress(address);
		incomeAddressFillPage.enterCity(city);
		incomeAddressFillPage.selectState(state);
		incomeAddressFillPage.enterZip(zip);
		yourIncomePage = incomeAddressFillPage.clickContinuetoIncomeButton();
			Action.fluentWait(getDriver(), yourIncomePage.annualIncomeTextBox, 10);
		yourIncomePage.enterAnnualIncome(annualIncome);
		yourIncomePage.selectIncomeType(incomeType);
			Action.fluentWait(getDriver(), yourIncomePage.companyNameTextBox, 10);
		yourIncomePage.enterCompanyName(companyName);
		aboutYouDOBSSNPage = yourIncomePage.clickContinueToAboutYouButton();
			Action.fluentWait(getDriver(), aboutYouDOBSSNPage.dobTextBox, 10);
		aboutYouDOBSSNPage.enterDOB(dob);
		aboutYouDOBSSNPage.enterSSN(ssn);
		selectOfferPage = aboutYouDOBSSNPage.clickSeeOptionsButton();
			getDriver().manage().timeouts().wait(30000);
			Action.fluentWait(getDriver(), selectOfferPage.congratulationsText, 60);
		offerConfirmPage = selectOfferPage.clickConfirmOfferButton();
			Action.fluentWait(getDriver(), offerConfirmPage.offerConfirmedText, 60);
		connectDepositAccountPage = offerConfirmPage.clickLetsGoButton();
			Action.fluentWait(getDriver(), connectDepositAccountPage.connectDepositAccountText, 60);
		connectDepositAccountPage.clickConnectBankButton();
		Log.endTestCase("User finished entering Personal Information");
	}
}
