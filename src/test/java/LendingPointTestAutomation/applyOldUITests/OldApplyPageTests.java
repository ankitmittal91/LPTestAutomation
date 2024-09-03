package LendingPointTestAutomation.applyOldUITests;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.pageFactory.applyNewUI.*;
import LendingPointTestAutomation.pageFactory.applyOldUI.*;
import LendingPointTestAutomation.utility.ExtentManager;
import LendingPointTestAutomation.utility.Log;

public class OldApplyPageTests extends BaseClass{

	OldApplyPage oldApplyPage;
	OldOfferPage oldOfferPage;
	OldBankInformationPage oldBankInformationPage;
	OldIncomeInformationPage oldIncomeInformationPage;
	OldIncomeInformationPage oldPaymentSetupPage;
	OldSignContractPage oldSignContractPage;

	@BeforeClass (groups = {"Sanity","Smoke","APISmokeSuite"})
	public void launchApplication() {
		launchBrowser(prop.getProperty("oldApplyUIUrl"), prop.getProperty("browserType"));
		oldApplyPage = new OldApplyPage();
		Action.fluentWait(getDriver(), oldApplyPage.loanAmountTextBox, 30);
	}

	@AfterClass (groups = {"Sanity","Smoke","APISmokeSuite"})
	public void tearDown() {
		if(getDriver() != null) {
			getDriver().quit();
		}
	}

	@Test (groups = {"Smoke"})
	public void oldApplyFundingFlow() throws InterruptedException {
		Log.startTestCase("User starts entering Personal Information");
		oldApplyPage.enterLoanAmount("5000");
		oldApplyPage.selectLoanPurpose("Unexpected Urgent Expense");
		oldApplyPage.enterFirstName("John");
		oldApplyPage.enterLastName("Smith");
		oldApplyPage.enterDOB("02281975");
		oldApplyPage.enterPhone("2127290858");
		Action.fluentWait(getDriver(), oldApplyPage.checkPhoneTick, 20);
		Log.info("User has filled the form till phone number");
		oldApplyPage.enterEmail("kbisht@lendingpoint.com");
		Action.fluentWait(getDriver(), oldApplyPage.checkEmailTick, 20);
		oldApplyPage.enterAddress1("222333 PEACHTREE PLACE");
		oldApplyPage.enterZipCode("30318");
		Action.fluentWait(getDriver(), oldApplyPage.zipCheckImage, 2);
		Log.info("User has filled the form till Zip");
		oldApplyPage.selectIncomeSource("Employee");
		oldApplyPage.enterAnnualIncome("98000");
		oldApplyPage.enterSSN("112223333");
		oldApplyPage.enterPassword("Test@123");
		oldOfferPage = oldApplyPage.clickCheckMyOptionButton();
		Log.info("User has clicked check my options button");
		Action.fluentWait(getDriver(), oldOfferPage.blockscreenHide, 30);
		Action.fluentWait(getDriver(), oldOfferPage.selectOfferTitle, 30);
		Assert.assertEquals(Action.isDisplayed(getDriver(), oldOfferPage.selectOfferTitle), true);
		Action.fluentWait(getDriver(), oldOfferPage.phoneVerificationPopupTitle, 10);
		if(Action.isDisplayed(getDriver(), oldOfferPage.phoneVerificationPopupTitle) == true) {
			Log.info("User is on Phone verification popup");
			Action.fluentWait(getDriver(), oldOfferPage.resendCodeButton, 10);
			oldOfferPage.enterVerificationCode("11234");
			Log.info("User has entered verification code");
			Action.fluentWait(getDriver(), oldOfferPage.verificationPopupError, 10);
			oldOfferPage.closeVerificationPopup();
			Log.info("User has exited Phone verification popup");
			Action.fluentWait(getDriver(), oldOfferPage.chooseButton, 10);
		}
		if(Action.findElement(getDriver(), oldOfferPage.newSlider) == true) {
			Action.fluentWait(getDriver(), oldOfferPage.chooseButton, 10);
			oldBankInformationPage = oldOfferPage.clickChooseButton();
			oldBankInformationPage = oldOfferPage.clickChooseButton();
			Log.info("User has selected offer on new offer page");
		} else { 
			Action.fluentWait(getDriver(), oldOfferPage.chooseButton, 10);
			oldBankInformationPage = oldOfferPage.clickChooseButton();
			oldBankInformationPage = oldOfferPage.clickChooseButton();
			Log.info("User has selected offer on old offer page");
		}
		Action.pageLoadTimeOut(getDriver(), 30);
		Action.fluentWait(getDriver(), oldBankInformationPage.blockscreenLoaderHidden, 30);
		Action.fluentWait(getDriver(), oldBankInformationPage.blockscreenLoader, 30);
		Action.fluentWait(getDriver(), oldBankInformationPage.bankInformationTitle, 30);
		Action.fluentWait(getDriver(), oldBankInformationPage.connectPlaidButton, 30);
		oldBankInformationPage = oldBankInformationPage.clickConnectPlaidButton();
		Log.info("User has clicked connect with Plaid button");
		Action.fluentWait(getDriver(), oldBankInformationPage.blockscreenLoaderHidden, 30);
		Action.fluentWaitTillExists(getDriver(), oldBankInformationPage.plaidIframe, 20);
		getDriver().switchTo().frame(oldBankInformationPage.plaidIframe);
		Action.fluentWait(getDriver(), oldBankInformationPage.plaidContinueButton, 5);
		oldBankInformationPage.clickContinuePlaidButton();
		Log.info("User has clicked continue on Plaid frame");
		Action.fluentWait(getDriver(), oldBankInformationPage.plaidBankSearchBox, 20);
		oldBankInformationPage.searchPlaidBank("first platypus");
		Log.info("User has searched bank name on Plaid frame");
		Action.fluentWait(getDriver(), oldBankInformationPage.plaidSearchResultTile1, 10);
		oldBankInformationPage.selectPlaidBank1();
		Action.fluentWait(getDriver(), oldBankInformationPage.plaidInstitutionsFoundTile, 10);
		oldBankInformationPage.selectPlaidBank2();
		Log.info("User has selected bank on Plaid frame");
		Action.fluentWait(getDriver(), oldBankInformationPage.plaidUsernameTextBox, 20);
		oldBankInformationPage.enterPlaidUsername("user_custom");
		oldBankInformationPage.enterPlaidPassword("{\"override_accounts\":[{\"starting_balance\":23630,\"type\":\"depository\",\"subtype\":\"checking\",\"identity\":{\"names\":[\"John Smith\"]}},{\"starting_balance\":25215,\"type\":\"depository\",\"subtype\":\"savings\",\"identity\":{\"names\":[\"John Smith\"]}}]}");
		Log.info("User has entered bank credentials on Plaid frame");
		Action.fluentWait(getDriver(), oldBankInformationPage.plaidSubmitButton, 10);
		oldBankInformationPage.clickPlaidSubmitButton1();
		Action.fluentWait(getDriver(), oldBankInformationPage.plaidSavingAccountTile, 10);
		oldBankInformationPage.clickPlaidSavingAccountTile();
		Action.fluentWait(getDriver(), oldBankInformationPage.plaidSubmitButton, 10);
		oldBankInformationPage.clickPlaidSubmitButton1();
		Action.fluentWait(getDriver(), oldBankInformationPage.plaidSubmitButton, 10);
		oldPaymentSetupPage = oldBankInformationPage.clickPlaidSubmitButton2();
		Log.info("User has completed Plaid flow");
		getDriver().switchTo().parentFrame();
		Action.fluentWait(getDriver(), oldPaymentSetupPage.blockscreenHide, 20);
		Action.fluentWait(getDriver(), oldPaymentSetupPage.paymentSetupTab, 10);
		if(Action.findElement(getDriver(), oldPaymentSetupPage.paymentSetupTab) == true) {
			Action.fluentWait(getDriver(), oldPaymentSetupPage.achButton, 30);
			oldSignContractPage = oldPaymentSetupPage.clickPaymentSetupNextButton();
		} else {
			Action.fluentWait(getDriver(), oldIncomeInformationPage.employmentPageTitle, 20);
			oldPaymentSetupPage = oldIncomeInformationPage;
			oldIncomeInformationPage.enterEmployerName("ABC Corp");
			oldIncomeInformationPage.enterEmployerPhone("9878978665");
			oldIncomeInformationPage.enterWorkEmail("abc@lendingpoint.com");
			oldIncomeInformationPage.enterJobTitle("Dev");
			oldIncomeInformationPage.enterStartDate("02/29/2008");
			oldPaymentSetupPage = oldIncomeInformationPage.clickEmploymentNextButton();
			Action.pageLoadTimeOut(getDriver(), 10);
			Action.fluentWait(getDriver(), oldPaymentSetupPage.achButton, 30);
			oldSignContractPage = oldPaymentSetupPage.clickPaymentSetupNextButton();
		}
		Action.pageLoadTimeOut(getDriver(), 10);
		Action.fluentWait(getDriver(), oldSignContractPage.amountFinancedTileTitle, 30);
		oldSignContractPage.clickCheckBox1();
		oldSignContractPage.clickCheckBox2();
		oldSignContractPage.clickSignAgreementButton();
	}

}
